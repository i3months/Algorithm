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

        long[][] dp = new long[K + 1][N + 1];

        for(int i=1; i<K+1; i++){
            for(int j=0; j<N+1; j++){
                if(i == 1 || j == 0){
                    dp[i][j] = 1;
                }else{
                    long sum = 0;
                    for(int k=0; k < j + 1; k++){
                        sum += dp[i-1][k];
                        sum %= 1_000_000_000;
                    }
                    dp[i][j] = sum;                    
                }               
            }
        }
        
        System.out.println(dp[K][N]);

    }
}