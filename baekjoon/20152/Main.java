import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static long[][] dp;
    static int H, N;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int size = Math.abs(H - N);

        dp = new long[size + 1][size + 1];

        

        for(int i=0; i<size + 1; i++){
            for(int j=0; j<size + 1; j++){

                if(i < j){
                    continue;
                }

                if(i == 0){
                    dp[i][j] = 1;
                }else   

                if(j == 0){
                    dp[i][j] = 1;
                }

                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }     

                
                
            }
        }

        System.out.println(dp[size][size]);

        // for(int i=0; i<size + 1 ;i++){
        //     for(int j=0; j<size+1; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

       
    }
}