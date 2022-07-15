import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visit;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int hole_r, hole_c;
    static Marble red, blue;

    static String an;

    static HashMap<Integer, String> hm = new HashMap<>();    


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hm.put(0, "U");
        hm.put(1, "D");
        hm.put(2, "L");
        hm.put(3, "R");

        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M][N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char tmp = str.charAt(j);

                map[i][j] = tmp;
                
                if(tmp == 'O'){
                    hole_r = i;
                    hole_c = j;
                }

                if(tmp == 'B'){
                    blue = new Marble(0,0,i,j,0, "");                    
                }

                if(tmp == 'R'){
                    red = new Marble(i,j,0,0,0, "");
                }
            }
        }

        int ans = bfs();       
        System.out.println(ans);        
        
        if(ans != -1){
            System.out.println(an);
        }


    }

    static int bfs(){
        Queue<Marble> q = new LinkedList<>();
        q.add(new Marble(red.red_r, red.red_c, blue.blue_r, blue.blue_c, 1, ""));

        visit[red.red_r][red.red_c][blue.blue_r][blue.blue_c] = true;

        while(!q.isEmpty()){
            Marble marble = q.poll();

            int cur_red_r = marble.red_r;
            int cur_red_c = marble.red_c;

            int cur_blue_r = marble.blue_r;
            int cur_blue_c = marble.blue_c;

            int cur_cnt = marble.cnt;         
            
            if(cur_cnt > 10){
                return -1;
            }

            for(int i=0; i<4; i++){
                int next_red_r = cur_red_r;
                int next_red_c = cur_red_c;

                int next_blue_r = cur_blue_r;
                int next_blue_c = cur_blue_c;


                boolean red_chk = false;
                boolean blue_chk = false;

                while(true){                 

                    if(map[next_red_r][next_red_c] == '#'){
                        next_red_r -= dr[i];
                        next_red_c -= dc[i];
                        break;
                    }

                    next_red_r += dr[i];
                    next_red_c += dc[i];                    

                    if(next_red_r == hole_r && next_red_c == hole_c){
                        red_chk = true;
                        break;
                    }
                }

                while(true){       
                    
                    if(map[next_blue_r][next_blue_c] == '#'){
                        next_blue_r -= dr[i];
                        next_blue_c -= dc[i];
                        break;
                    }

                    next_blue_r += dr[i];
                    next_blue_c += dc[i];                    

                    if(next_blue_r == hole_r && next_blue_c == hole_c){
                        blue_chk = true;
                        break;
                    }
                }

                if(blue_chk){
                    continue;
                }

                if(red_chk && !blue_chk){
                    an = marble.cmd + hm.get(i);                    
                    return cur_cnt;
                }

                if(next_red_r == next_blue_r && next_red_c == next_blue_c){
                    if(i == 0){
                        if(cur_red_r > cur_blue_r){
                            next_red_r = next_red_r - dr[i];
                        }else{
                            next_blue_r -= dr[i];
                        }
                    }

                    if(i == 1){
                        if(cur_red_r < cur_blue_r){
                            next_red_r -= dr[i];
                        }else{
                            next_blue_r -= dr[i];
                        }
                    }

                    if(i == 2){
                        if(cur_red_c > cur_blue_c){
                            next_red_c -= dc[i];
                        }else{
                            next_blue_c -= dc[i];
                        }
                    }

                    if(i == 3){
                        if(cur_red_c < cur_blue_c){
                            next_red_c -= dc[i];                            
                        }else{
                            next_blue_c -= dc[i];
                        } 
                    }
                }

                if(!visit[next_red_r][next_red_c][next_blue_r][next_blue_c]){
                    visit[next_red_r][next_red_c][next_blue_r][next_blue_c] = true;

                    if(i == 0){
                        q.add(new Marble(next_red_r, next_red_c, next_blue_r, next_blue_c, cur_cnt + 1, marble.cmd + "U"));
                    }
                    
                    if(i == 1){
                        q.add(new Marble(next_red_r, next_red_c, next_blue_r, next_blue_c, cur_cnt + 1, marble.cmd + "D"));
                    }

                    if(i == 2){
                        q.add(new Marble(next_red_r, next_red_c, next_blue_r, next_blue_c, cur_cnt + 1, marble.cmd + "L"));
                    }

                    if(i == 3){
                        q.add(new Marble(next_red_r, next_red_c, next_blue_r, next_blue_c, cur_cnt + 1, marble.cmd + "R"));
                    }
                }
            }
        }

        return -1;
    }
}

class Marble{
    int red_r;
    int red_c;

    int blue_r;
    int blue_c;

    int cnt;

    String cmd = "";

    public Marble(int red_r, int red_c, int blue_r, int blue_c, int cnt, String cmd) {
        this.red_r = red_r;
        this.red_c = red_c;
        this.blue_r = blue_r;
        this.blue_c = blue_c;
        this.cnt = cnt;
        this.cmd = cmd;
    }
    
}