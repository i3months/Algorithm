import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static int INF = 1000000000;
    static StringBuilder sb = new StringBuilder();
    static int n, m, k;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[101][101];

        for(int i=1; i<101; i++) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }

        for(int i=1; i<101; i++) {
            for(int j=1; j<101; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] = dp[i][j] >= INF ? INF : dp[i][j];
            }
        }

        if(dp[n][m] < k) {
            System.out.println(-1);
            return;
        }   

        solve(n, m, k);

        System.out.println(sb);        
        

    }   

    static void solve(int a, int z, int num) {
        if(a == 0) {
            for(int i=0; i<z; i++) sb.append("z");
            return;
        }

        if(z == 0) {
            for(int i=0; i<a; i++) sb.append("a");
            return;
        }

        int val = dp[a-1][z];
        
        if(num > val) {
            sb.append("z");
            solve(a, z-1, num - val);
        } else {
            sb.append("a");
            solve(a-1, z, num);
        }
        
        
    }
}
