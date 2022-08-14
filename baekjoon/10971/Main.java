import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N;
    static int[][] W;
    static boolean[]  visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        W = new int[N + 1][N + 1];
        visit= new boolean[N + 1];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<N + 1; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit[2] = true;

        dfs(2,2,1,0);
        System.out.println(min);
        
        
    }

    static void dfs(int start, int now, int cnt, int cost){
        if(now == start && cost > 0){
            min = Math.min(min, cost);
            return;
        } // basis

        
        for(int i=1; i<N+1; i++){
            if(W[now][i] == 0){
                continue;
            }

            if(i == start && cnt == N){
                cost += W[now][i];
                dfs(start, i, 0, cost); // basis로 ㄱㄱ
            }else if(!visit[i]){ // 방문안한곳만가
                //백트래킹 ㄱㄱ 
                visit[i] = true;
                cost += W[now][i];

                dfs(start, i, cnt + 1, cost);

                visit[i] = false;
                cost -= W[now][i];                
                
            }
        }
    }
}