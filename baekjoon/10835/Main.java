import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static final int INF = 987654321;  
    static int N;
    static int ans = -1;  
    static int[][] dp;
    static int[] leftC;
    static int[] rightC;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][N + 1];
        leftC = new int[N + 1];
        rightC = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            leftC[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            rightC[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<N+1; i++) {
            Arrays.fill(dp[i], -1);
        }
                        
        System.out.println(solve(1, 1));
        
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