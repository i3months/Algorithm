import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int N = Integer.parseInt(st.nextToken());
        
        long[][] dp = new long[N + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for(int i =2; i<N+1; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][0] %= 9901;
        
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][1] %= 9901;

            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            dp[i][2] %= 9901;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);


        

        
    }
}