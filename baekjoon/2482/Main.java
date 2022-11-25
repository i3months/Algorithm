import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static final int INF = 987654321;

    static int[][] dp; 
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        dp = new int[N + 1][N + 1];





        System.out.println(solve(N, M));
    
        
        
    }

    static int solve(int cur, int cnt) {
        if(cnt == 1) return cur;

        if(cur <= 0 ||cur < 2 * cnt) return 0;

        if(dp[cur][cnt] != 0) return dp[cur][cnt];

        return dp[cur][cnt] = (solve(cur-2, cnt-1) + solve(cur-1, cnt)) % MOD;
    }
}