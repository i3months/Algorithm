import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N + 5];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i=4; i<N+1; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        System.out.println(dp[N] % 2 == 0 ? "CY" : "SK");
        
        
    }
}
