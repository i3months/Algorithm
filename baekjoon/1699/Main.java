import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long dp[];
    static long add = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];
        

        for(int i=1; i<N+1; i++){
            dp[i] = i;
            for(int j=1; j * j <= i; j++){
                if(dp[i] > dp[i - j*j] + 1){
                    dp[i] =dp[i - j*j] + 1; 
                }
            }
        }

        System.out.println(dp[N]);
    }
}