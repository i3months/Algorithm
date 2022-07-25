import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];        

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }    

        if(N == 1){
            System.out.println(arr[1]);
            return;
        }
        

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        int max = dp[2];

        for(int i=3; i<N+1; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));            
        }

        System.out.println(dp[N]);
        
        

    }
}    
