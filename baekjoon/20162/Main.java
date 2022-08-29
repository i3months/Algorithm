import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();
    static int arr[], dp[];
    static int N, max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }        

        dp[1] = arr[1];
        
        for(int i=2; i<N+1; i++){
            dp[i] = arr[i];
            for(int j=1; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }        

        System.out.println(max);
    
    }
}