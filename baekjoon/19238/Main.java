import java.util.*;
import java.io.*;
 
public class Main {
    
    static int N, M, K;
    static int[][] map;
    static int[][] visit;
    static int[][] cost;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    static int startR, startC;
    static int INF = 987654321;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = K;

        map = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());

        ArrayList<Locate> list = new ArrayList<>();        

        for(int i=10; i<10+M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[a][b] = i;
            list.add(new Locate(a,b));
            map[c][d] = -i;            
        }

        while(true){
            if(list.size() == 0) break;
            
            Queue<Locate> q = new LinkedList<>();

            visit = new int[N+1][N+1];
            visit[startR][startC] = 1;
            cost = new int[N+1][N+1];
            cost[startR][startC] = ans;

            q.add(new Locate(startR, startC, ans));

            while(!q.isEmpty()){
                Locate cur = q.poll();

                for(int i=0; i<4; i++){
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if(nextR >= N + 1 || nextR <= 0 || nextC >= N + 1 || nextC <= 0) continue;
                    if(map[nextR][nextC] == 1) continue;
                    if(cur.k <= 0) continue;
                    if(visit[nextR][nextC] != 0) continue;
                    
                    visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                    cost[nextR][nextC] = cost[cur.r][cur.c] - 1;
                    q.add(new Locate(nextR, nextC, cur.k - 1));
                }
            }

            int min = INF;
            int beforeR = startR;
            int beforeC = startC;

            for(Locate k : list){
                if(visit[k.r][k.c] == 0) continue;

                if(min == visit[k.r][k.c]){
                    if(startR > k.r){
                        startR = k.r;
                        startC = k.c;
                    }

                    if(startR == k.r && startC > k.c){
                        startR = k.r;
                        startC = k.c;
                    }
                }

                if(min > visit[k.r][k.c]){
                    startR = k.r;
                    startC = k.c;
                    min = visit[k.r][k.c];
                }
            }

            if(startR == beforeR && startC == beforeC){
                System.out.println(-1);
                return;
            } 

            int curCost = cost[startR][startC];

            // System.out.println(startR + " " + startC + " " + curCost);

            visit = new int[N+1][N+1];
            visit[startR][startC] = 1;
            cost = new int[N+1][N+1];
            cost[startR][startC] = curCost;

            Queue<Locate> q2 = new LinkedList<>();

            q2.add(new Locate(startR, startC, curCost));
            int target = -map[startR][startC];

            int targetR = 0;
            int targetC = 0;

            while(!q2.isEmpty()){
                Locate cur = q2.poll();

                if(map[cur.r][cur.c] == target){
                    targetR = cur.r;
                    targetC = cur.c;
                    break;
                }

                for(int i=0; i<4; i++){
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if(nextR >= N+1 || nextR <= 0 || nextC >= N+1 || nextC <= 0) continue;
                    if(map[nextR][nextC] == 1) continue;
                    if(visit[nextR][nextC] != 0) continue;
                    if(cur.k <= 0) continue;

                    visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                    cost[nextR][nextC] = cost[cur.r][cur.c] - 1;

                    q2.add(new Locate(nextR, nextC, cur.k - 1));
                    
                }                                
            }

            // System.out.println("map");
            // for(int i=1; i<N+1; i++){
            //     for(int j=1; j<N+1; j++){
            //         System.out.printf("%3d ", map[i][j]);
            //     }System.out.println();
            // }                        
            // System.out.println("visit");
            // for(int i=1; i<N+1; i++){
            //     for(int j=1; j<N+1; j++){
            //         System.out.printf("%3d ", visit[i][j]);
            //     }System.out.println();
            // }
            // System.out.println("cost");
            // for(int i=1; i<N+1; i++){
            //     for(int j=1; j<N+1; j++){
            //         System.out.printf("%3d ", cost[i][j]);
            //     }System.out.println();
            // }

            if(targetR == 0 && targetC == 0){
                System.out.println(-1);
                return;
            }

            curCost = cost[targetR][targetC];
            int spendCost = cost[startR][startC] - cost[targetR][targetC];

            // System.out.println(targetR + " " + targetC + " " + spendCost);
            
            ans = curCost + (spendCost * 2);

            list.remove(new Locate(startR, startC));
            
            startR = targetR;
            startC = targetC;
            
            // break;
        }
        
        
        System.out.println(ans);
        
    }
}

class Locate{
    int r, c, k;
    Locate(int r, int c, int k){this.r=r;this.c=c; this.k=k;}
    Locate(int r, int c){this.r=r;this.c=c;}

    @Override
    public boolean equals(Object o2){
        Locate o3 = (Locate)o2;
        if(o3.r == r && o3.c == c){
            return true;
        }else{
            return false;
        }
    }

}