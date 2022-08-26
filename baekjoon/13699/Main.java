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

        dp[0] = 1;
        if(N == 0){
            System.out.println(1);
            return;
        }
        dp[1] = 1;

        for(int i=2; i<N+1; i++){
            add = 0;
            for(int j = 0; j<i; j++){
                add += dp[j] * dp[i - j - 1];
            }

            dp[i] = add;
        }

        System.out.println(dp[N]);
        

    }
}