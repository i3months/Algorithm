import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][1001];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i=4; i<1001; i++){
            for(int j=2; j<i + 1; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1];    
                dp[i][j] %= 1_000_000_009;                            
            }
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(dp[A][B] + "\n");            
        }

        System.out.println(sb);


        
    }
}