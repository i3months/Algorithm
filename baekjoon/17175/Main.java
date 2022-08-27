import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        if(N < 2){
            System.out.println(1);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;

       
        

        for(int i=2; i<N+1; i++){
            dp[i] = dp[i-2] + dp[i-1] + 1;
            dp[i] %= 1_000_000_007;
        }

        System.out.println(dp[N]);


    }

    static int fibonacci(int n){
        if(n < 2){
            return 2;
        }
        return fibonacci(n-2) + fibonacci(n-1);
    }
}