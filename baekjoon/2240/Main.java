import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000000;
    static final int INF = 987654321;

    static int[][] dp; 
    static int[] arr;
    static int N, M;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];

        arr = new int[N + 1];
        
        for(int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i] %= 2;
        }

        int max =  solve(1, 0);

        System.out.println(max);

    
        
        
    }

    static int solve(int idx, int move) {
        if(move > M) return -INF;

        if(idx == N + 1) return 0;

        if(dp[idx][move] != 0) return dp[idx][move];

        dp[idx][move] = solve(idx + 1, move);
        
        if(arr[idx] != move % 2) dp[idx][move] = Math.max(dp[idx][move], solve(idx + 1, move) + 1);
        else dp[idx][move] = Math.max(dp[idx][move], solve(idx + 1, move + 1) + 1);

        return dp[idx][move];
        
    }
}