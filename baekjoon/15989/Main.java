import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for(int i=4; i<10001; i++){
            dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}

        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());

            System.out.println(dp[val][1] + dp[val][2] + dp[val][3]);
        }


        
    }
}