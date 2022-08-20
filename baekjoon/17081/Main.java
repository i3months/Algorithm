import java.util.*;
import java.io.*;

public class Main {
    static int N, M, monsterCnt, itemCnt, firstR, firstC;
    static String killedBy;
    static char[][] map;
    static int turnCnt;

    static Monster[][] monsterMap;
    static Item[][] itemMap;

    static int spikeDamage;
    static int getEXP;

    static Hero hero;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        monsterMap = new Monster[N][M];
        itemMap = new Item[N][M];


        hero = new Hero();

        // 맵 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char tmp = str.charAt(j);

                if (tmp == '&' || tmp == 'M') {
                    monsterCnt++;
                }

                if (tmp == 'B') {
                    itemCnt++;
                }

                if (tmp == '@') {
                    hero.r = i;
                    hero.c = j;
                    firstR = i;
                    firstC = j;
                }

                map[i][j] = tmp;
            }
        }

        map[firstR][firstC] = '.';

        // 커맨드 입력
        String S = br.readLine();

        // 몬스터 정보 입력
        for (int i = 0; i < monsterCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();
            int attack = Integer.parseInt(st.nextToken());
            int defence = Integer.parseInt(st.nextToken());
            int maxHP = Integer.parseInt(st.nextToken());
            int getEXP = Integer.parseInt(st.nextToken());

            monsterMap[r][c] = new Monster(name, attack, defence, maxHP, getEXP, maxHP);
        }

        // 아이템 정보 입력
        for (int i = 0; i < itemCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            char kind = st.nextToken().charAt(0);
            String value = st.nextToken();

            itemMap[r][c] = new Item(kind, value);
        }

        // 캐릭터 초기화
        hero.curHP = 20;
        hero.maxHP = 20;
        hero.attack = 2;
        hero.defence = 2;
        hero.level = 1;
        hero.weapon = 0;
        hero.armor = 0;
        hero.curEXP = 0;
        hero.maxEXP = 5 * hero.level;


        // 커맨드에 따라 이동하면서 로직 수행
        for (int i = 0; i < S.length(); i++) {

            // debug
//            System.out.println("location R :" + hero.r + " C :" + hero.c);

            // 턴 하나 증가
            turnCnt++;

            // 커맨드에 따라 다음 장소 지정
            int curR = hero.r;
            int curC = hero.c;

            int nextR = curR;
            int nextC = curC;

            if (S.charAt(i) == 'U') {
                nextR = curR - 1;
            }

            if (S.charAt(i) == 'L') {
                nextC = curC - 1;
            }

            if (S.charAt(i) == 'R') {
                nextC = curC + 1;
            }

            if (S.charAt(i) == 'D') {
                nextR = curR + 1;
            }


            // 경로 이탈 확인
            if (nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1) {
                // 가시함정 체크해주자.
                if (map[curR][curC] == '^') {
                    updateSpikeDamage();
                    hero.curHP -= spikeDamage;
                    // 죽을 때 로직은?
                    if(hero.curHP <= 0){
                        death(0,0,3);
                        continue;
                    }

                }
                continue;
            }

            // 벽 확인
            if (map[nextR][nextC] == '#') {
                // 가시함정 체크해주자.
                if (map[curR][curC] == '^') {
                    updateSpikeDamage();
                    hero.curHP -= spikeDamage;
                    // 죽을 때 로직은?
                    if(hero.curHP <= 0){
                        death(0,0,3);
                        continue;
                    }
                }
                continue;
            }

            // 가시 함정
            if (map[nextR][nextC] == '^') {
                updateSpikeDamage();
                hero.curHP -= spikeDamage;
                // 죽을 때 로직은?
                if(hero.curHP <= 0){
                    death(0,0,3);
                    continue;
                }

                // 위치 이동.
                hero.r = nextR;
                hero.c = nextC;
            }else

                // 아이템 상자
                if (map[nextR][nextC] == 'B') {
                    // 무기 뽑음
                    if (itemMap[nextR][nextC].kind == 'W') {
                        hero.weapon = Integer.parseInt(itemMap[nextR][nextC].value);
                    }

                    // 방어구 뽑음
                    if (itemMap[nextR][nextC].kind == 'A') {
                        hero.armor = Integer.parseInt(itemMap[nextR][nextC].value);
                    }

                    // 장신구 뽑음
                    if (itemMap[nextR][nextC].kind == 'O') {
                        if (hero.accessory.size() < 4 && !hero.accessory.contains(itemMap[nextR][nextC].value)) {
                            hero.accessory.add(itemMap[nextR][nextC].value);
                        }
                    }

                    // 위치 이동
                    hero.r = nextR;
                    hero.c = nextC;

                    // 맵 업데이트
                    map[nextR][nextC] = '.';
                }else

                    // 몬스터 만남 (보스 아님)
                    if (map[nextR][nextC] == '&') {
                        if (battle(nextR, nextC)) {
                            // 이겼음

                            // 맵 업데이트
                            map[nextR][nextC] = '.';

                            // 이동
                            hero.r = nextR;
                            hero.c = nextC;

                            // HR 있으면 체력 회복
                            if (hero.accessory.contains("HR")) {
                                hero.curHP += 3;
                                hero.curHP = Math.min(hero.curHP, hero.maxHP);

                            }

                            // 경험치 정산 (장신구 고려)
                            if (hero.accessory.contains("EX")) {
                                getEXP = (int) (monsterMap[nextR][nextC].getEXP * 1.2);
                            } else {
                                getEXP = monsterMap[nextR][nextC].getEXP;
                            }

                            hero.curEXP += getEXP;

                            // 레벨업 처리
                            if (hero.curEXP >= hero.maxEXP) {
                                hero.curEXP = 0;
                                hero.level++;
                                hero.maxEXP = 5 * hero.level;
                                hero.maxHP += 5;
                                hero.curHP = hero.maxHP;
                                hero.attack += 2;
                                hero.defence += 2;
                            }


                        } else {
                            // 죽었음
                            death(nextR, nextC, 1);
                            continue;

                        }

                    }else

                        // 보스몬스터 만났음
                        if (map[nextR][nextC] == 'M') {
                            if (bossBattle(nextR, nextC)) {
                                // 이겼음

                                // 맵 업데이트
                                map[nextR][nextC] = '.';

                                // 이동
                                hero.r = nextR;
                                hero.c = nextC;

                                // HR 있으면 체력 회복
                                if (hero.accessory.contains("HR")) {
                                    hero.curHP += 3;
                                    hero.curHP = Math.min(hero.curHP, hero.maxHP);
                                }

                                // 경험치 정산 (장신구 고려)
                                if (hero.accessory.contains("EX")) {
                                    getEXP = (int) (monsterMap[nextR][nextC].getEXP * 1.2);
                                } else {
                                    getEXP = monsterMap[nextR][nextC].getEXP;
                                }

                                hero.curEXP += getEXP;

                                // 레벨업 처리
                                if (hero.curEXP >= hero.maxEXP) {
                                    hero.curEXP = 0;
                                    hero.level++;
                                    hero.maxEXP = 5 * hero.level;
                                    hero.maxHP += 5;
                                    hero.curHP = hero.maxHP;
                                    hero.attack += 2;
                                    hero.defence += 2;
                                }

                                print(0);


                            } else {
                                // 죽었음
                                death(nextR, nextC, 2);
                                continue;

                            }

                        }else if(map[nextR][nextC] == '.'){
                            hero.r = nextR;
                            hero.c = nextC;
                        }


        }

        print(-1);

    }

    static void death(int r, int c, int key){
        if(hero.accessory.contains("RE")){
            hero.curHP = hero.maxHP;
            hero.accessory.remove("RE");
            if(key == 1 || key == 2){
                monsterMap[r][c].curHP = monsterMap[r][c].maxHP;
            }
            hero.r = firstR;
            hero.c = firstC;
        }else{
            if(key == 1){
                killedBy = monsterMap[r][c].name;
            }else if(key == 2){
                killedBy = monsterMap[r][c].name;
            }else if(key == 3){
                killedBy = "SPIKE TRAP";
            }

            print(key);
        }

    }

    static boolean bossBattle(int r, int c){

        if(hero.accessory.contains("HU")){
            hero.curHP = hero.maxHP;
        }

        int heroAttack = hero.attack + hero.weapon;
        int heroDefence = hero.defence + hero.armor;
        int buffedHeroAttack = heroAttack * 2;
        int a = heroAttack * 3;

        int monsterAttack = monsterMap[r][c].attack;
        int monsterDefence = monsterMap[r][c].defense;

        int heroToMonster = Math.max(1, heroAttack - monsterDefence);
        int buffedHeroToMonster = Math.max(1, buffedHeroAttack - monsterDefence);
        int b = Math.max(1, a - monsterDefence);
        int monsterToHero = Math.max(1, monsterAttack - heroDefence);

        for(int i =0;;i++){

            if(i == 0 && hero.accessory.contains("CO") && hero.accessory.contains("DX")){
                monsterMap[r][c].curHP -= b;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                if(!hero.accessory.contains("HU")){
                    hero.curHP -= monsterToHero;
                }

                if(hero.curHP <= 0){
                    return false;
                }

            }else if(i == 0 && hero.accessory.contains("CO")){
                monsterMap[r][c].curHP -= buffedHeroToMonster;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                if(!hero.accessory.contains("HU")){
                    hero.curHP -= monsterToHero;
                }
                if(hero.curHP <= 0){
                    return false;
                }
            } else{
                monsterMap[r][c].curHP -= heroToMonster;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                hero.curHP -= monsterToHero;
                if(hero.curHP <= 0){
                    return false;
                }

            }
        }


    }

    static boolean battle(int r, int c){

        int heroAttack = hero.attack + hero.weapon;
        int heroDefence = hero.defence + hero.armor;
        int buffedHeroAttack = heroAttack * 2;
        int a = heroAttack * 3;

        int monsterAttack = monsterMap[r][c].attack;
        int monsterDefence = monsterMap[r][c].defense;

        int heroToMonster = Math.max(1, heroAttack - monsterDefence);
        int buffedHeroToMonster = Math.max(1, buffedHeroAttack - monsterDefence);
        int b = Math.max(1, a - monsterDefence);
        int monsterToHero = Math.max(1, monsterAttack - heroDefence);

        for(int i =0;;i++){

            if(i == 0 && hero.accessory.contains("CO") && hero.accessory.contains("DX")){
                monsterMap[r][c].curHP -= b;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                hero.curHP -= monsterToHero;
                if(hero.curHP <= 0){
                    return false;
                }

            }else if(i == 0 && hero.accessory.contains("CO")){
                monsterMap[r][c].curHP -= buffedHeroToMonster;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                hero.curHP -= monsterToHero;
                if(hero.curHP <= 0){
                    return false;
                }
            }else{
                monsterMap[r][c].curHP -= heroToMonster;
                if(monsterMap[r][c].curHP <= 0){
                    return true;
                }
                hero.curHP -= monsterToHero;
                if(hero.curHP <= 0){
                    return false;
                }

            }
        }

    }

    static void print(int key){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(i == hero.r && j == hero.c){
                    if(key == -1 || key == 0){
                        System.out.print('@');
                    }else{
                        System.out.print(map[i][j]); // ?
                    }
                }else{
                    System.out.print(map[i][j]);
                }

            }
            System.out.println();
        }

        hero.curHP = hero.curHP <= 0 ? 0 : hero.curHP;

        System.out.println("Passed Turns : " + turnCnt);
        System.out.println("LV : " + hero.level);
        System.out.println("HP : " + hero.curHP + "/" + hero.maxHP);
        System.out.println("ATT : " + hero.attack + "+" + hero.weapon);
        System.out.println("DEF : " + hero.defence + "+" + hero.armor);
        System.out.println("EXP : " + hero.curEXP + "/" + hero.maxEXP);

        if(key == 0){
            System.out.println("YOU WIN!");
        }else if(key == 1 || key == 2 || key == 3){
            System.out.println("YOU HAVE BEEN KILLED BY " + killedBy + "..");
        }else{
            System.out.println("Press any key to continue.");
        }

        System.exit(0);

    }

    private static void updateSpikeDamage() {
        if(hero.accessory.contains("DX")){
            spikeDamage = 1;
        }else{
            spikeDamage = 5;
        }
    }

}

class Monster{
    String name;
    int attack, defense, maxHP, getEXP, curHP;

    public Monster(String name, int attack, int defense, int maxHP, int getEXP, int curHP) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxHP = maxHP;
        this.getEXP = getEXP;
        this.curHP = curHP;
    }
}

class Item{
    char kind;
    String value;

    public Item(char kind, String value) {
        this.kind = kind;
        this.value = value;
    }
}

class Hero{
    int curHP, maxHP, attack, defence, curEXP, maxEXP, level;

    int r, c;

    ArrayList<String> accessory = new ArrayList<>();
    int weapon;
    int armor;

    Hero(){}

}
