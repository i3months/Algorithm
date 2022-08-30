import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[N + 1];
        

        for(int i=1; i<N+1; i++){
            dp[i] = arr[i];
            for(int j=1; j<i; j++){
                dp[i] = Math.min(dp[i],dp[i - j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
        
    }
}