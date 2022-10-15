import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] weight;
    static int[][] dp;
    static ArrayList<Integer> a = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

        visit = new boolean[N+1];
        weight = new int[N+1];
        dp = new int[N+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        solve2(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));

        // for(int k : weight){
        //     System.out.print(k + " ");
        // }
        
        // System.out.println(dp[1][0]);
        // System.out.println(dp[1][1]);

        visit = new boolean[N + 1];

        trace(1, 0);        

        Collections.sort(a);

        for(int k : a){
            System.out.print(k+  " ");
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