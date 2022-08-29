import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1000][K + 1000];

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int i=2; i<N+1; i++){
            for(int j=0; j<K+1; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else
                if(i == j){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];     
                    dp[i][j] %= 10_007;           
                }
                
            }
        }

        System.out.println(dp[N][K]);
        
    }
}