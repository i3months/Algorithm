import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static final int INF = 987654321;  
    static int N;
    static int ans = -1;  
    static int[][] dp;
    static int[] arr;

    static int[] leftC;
    static int[] rightC;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[N + 1][N + 1];
            arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N+1; i++) {
                Arrays.fill(dp[i], -1);
            }
            
            System.out.println(solve2(1, N, 1));
            
            
        }           
        
    }    

    static int solve2(int left, int right, int turn) {
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        dp[left][right] = 0;

        if(turn % 2 == 1) {
            dp[left][right] = Math.max(arr[left] + solve2(left+1, right, turn+1), arr[right] + solve2(left, right-1, turn+1));
        } else {   
            dp[left][right] = Math.min(solve2(left+1, right, turn+1), solve2(left, right-1, turn+1));
        }
        
        // dp[left][right] = Math.max(dp[left][right], solve2(left+2, right) + arr[left]);
        // dp[left][right] = Math.max(dp[left][right], solve2(left, right-2) + arr[right]);
        // dp[left][right] = Math.max(dp[left][right], solve2(left+1, right-1) + arr[right]);
        // dp[left][right] = Math.max(dp[left][right], solve2(left+1, right-1) + arr[left]);

        return dp[left][right];
    }

    static int solve(int left, int right) {
        if(left == N+1 || right == N+1) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        dp[left][right] = 0;

        if(rightC[right] < leftC[left]) dp[left][right] += rightC[right] + solve(left, right + 1);
        else dp[left][right] += Math.max(solve(left + 1, right), solve(left+1, right+1));

        return dp[left][right];
    }
}