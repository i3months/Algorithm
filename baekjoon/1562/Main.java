import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000000;
    static final int INF = 987654321;

    static int[][][] dp;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10][1 << 10];

        for(int i=1; i<10; i++) {
            ans += dfs(1, i, 1 << i);
            ans %= MOD;
        }

        System.out.println(ans);
        
    }

    static int dfs(int idx, int num, int bit) {        
        if(dp[idx][num][bit] != 0) return dp[idx][num][bit];
        if(idx == N) return (bit == (1 << 10) - 1) ? 1 : 0;

        int res = 0;

        if(num + 1 < 10) res += dfs(idx + 1, num + 1, bit | 1 << (num + 1));
        if(num - 1 >= 0) res += dfs(idx + 1, num - 1, bit | 1 << (num - 1));

        res %= MOD;
        dp[idx][num][bit] = res;

        return dp[idx][num][bit];    
    }
}