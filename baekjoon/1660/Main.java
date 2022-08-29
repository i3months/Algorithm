import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                            

        int N = Integer.parseInt(br.readLine());
        
        int[] dp1 = new int[122];
        int[] dp2 = new int[122];

        dp1[1] = 1;

        for(int i= 2; i<122; i++){
            dp1[i] = dp1[i-1] + i;
        }

        dp2[1] = 1;

        for(int i=2; i<122; i++){
            dp2[i] = dp2[i-1] + dp1[i];
        }

        int[] dp = new int[N + 1];   
        Arrays.fill(dp, Integer.MAX_VALUE);     

        dp[0]=0;
        dp[1] = 1;

        for(int i=2; i<N+1; i++){            
            for(int j=1; j<122; j++){                
                if(dp2[j] > i){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - dp2[j]] + 1);                
            }
        }

        System.out.println(dp[N]);
        
    }
}