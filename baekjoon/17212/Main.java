import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(0,0);
        hm.put(1,1);
        hm.put(2,1);
        hm.put(3,2);
        hm.put(4,2);
        hm.put(5,1);
        hm.put(6,2);
        hm.put(7,1);


        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        if(N < 8){
            System.out.println(hm.get(N));
            return;
        }
        

        for(int i=8; i<N+1; i++){
            dp[i] = dp[i - 7] + 1;
            dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        System.out.println(dp[N]);
    }
}