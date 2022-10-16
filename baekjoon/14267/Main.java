import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] weight;
    static int[][] dp;
    static int[] dp2;
    static ArrayList<Integer> a = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp2 = new int[N + 1];

        list = new ArrayList[N + 1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            int a = Integer.parseInt(st.nextToken());

            if(a == -1) continue;

            list[a].add(i);            
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            dp2[a] += b;
        }

        dfs(1);

        for(int i=1; i<N+1; i++){
            System.out.print(dp2[i] + " ");
        }
        


    }

    static void dfs(int cur){        

        for(int k : list[cur]){
            dp2[k] += dp2[cur];
            dfs(k);
        }
    }

    static void trace(int cur, int prev){
        if(dp[cur][1] > dp[cur][0] && !visit[prev]){
            a.add(cur);
            visit[cur] = true;
        }

        for(int k : list[cur]){
            if(k == prev) continue;
            trace(k, cur);
        }
    }
    
    static void solve2(int cur){
        visit[cur] = true;

        // 1 mean i pick this node
        dp[cur][0] = 0;
        dp[cur][1] = weight[cur];

        for(int k : list[cur]){
            if(visit[k]) continue;
            solve2(k);

            dp[cur][0] += Math.max(dp[k][1], dp[k][0]);
            dp[cur][1] += dp[k][0];
        }
        
    }

    static void solve(int cur){
        visit[cur] = true;

        dp[cur][0] = 1;

        for(int k : list[cur]){
            if(visit[k]) continue;
            solve(k);

            dp[cur][1] += dp[k][0];
            dp[cur][0] += Math.min(dp[k][1], dp[k][0]);
        }
    }
}    