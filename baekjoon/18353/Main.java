import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                            

        int N = Integer.parseInt(br.readLine())        ;

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[N+1];


        Arrays.fill(dp, 1);

        for(int i=1; i<N + 1; i++){
            for(int j=1; j<i; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }    
        }

        int max = -1;

        for(int k : dp){if(max<k)max=k;}

        System.out.println(N - max);

        
        
    }
}