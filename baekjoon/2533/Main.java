import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        dp = new int[N + 1][2];

        for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        solve(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
        
        
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