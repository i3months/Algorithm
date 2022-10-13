import java.io.*;
import java.util.*;
 
public class Main {
    static int INF = 987654321;
    static int[][] map;
    static boolean[] visit;

    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 1){
                System.out.println(0);
                continue;
            }

            map = new int[N + 1][N + 1];            
            visit = new boolean[N + 1];

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                map[a][b] = c;
                map[b][a] = c;                
            }
            
            int ans = 0;

            for(int i=1; i<N+1; i++){
                if(map[1][i] != 0){
                    int startNode = i;
                    int startCost = map[1][i];
                    ans += solve(startNode, startCost);
                }
            }

            System.out.println(ans);
            
            
        }

    }

    static int solve(int cur, int cost){
        visit[cur] = true;
        
        int num = 0;

        for(int i=1; i<N+1; i++){
            if(map[cur][i] != 0){
                num++;
            }
        }



        if(cur != 1 && num == 1) return cost;

        int sum = 0;

        for(int i=1; i<N+1; i++){
            if(map[cur][i] != 0){
                int nextNode = i;
                int nextCost = map[cur][i];

                if(nextNode != 1 && !visit[nextNode]){
                    sum += solve(nextNode, nextCost);
                }
            }
        }

        return Math.min(cost, sum);
    }
}    