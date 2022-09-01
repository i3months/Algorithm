import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[100_001][3];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 2;
        dp[3][2] = 2;

        for(int i=4; i<100_001; i++){
            dp[i][1] = dp[i - 1][2] + dp[i - 2][2] + dp[i - 3][2];
            dp[i][2] = dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1];
            dp[i][1] %= 1_000_000_009;
            dp[i][2] %= 1_000_000_009;
        }

        for(int i=0; i<N; i++){
            int K = Integer.parseInt(br.readLine());

            sb.append(dp[K][1] + " " + dp[K][2] + "\n");
        }
        System.out.println(sb);

        
    }
}