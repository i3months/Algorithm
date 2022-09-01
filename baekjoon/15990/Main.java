import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[100_001][4];

        dp[1][1] = 1;

        dp[2][2] = 1;
        
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4; i<100_001; i++){
            dp[i][1] = dp[i-1][2] + dp[i-1][3];
            dp[i][2] = dp[i-2][1] + dp[i-2][3];
            dp[i][3] = dp[i-3][1] + dp[i-3][2];
            for(int j=1; j<4; j++){
                dp[i][j] %= 1_000_000_009;
            }
        }

        for(int i=0; i<N; i++){
            long sum = 0;
            int K = Integer.parseInt(br.readLine());
            for(int j=1; j<4; j++){
                sum += dp[K][j];
                sum %= 1_000_000_009;
            }
            System.out.println(sum);
        }
        
    }
}