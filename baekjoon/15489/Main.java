import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int ans, N, K;
    static final int INF = 987654321;    
    static boolean bigbig;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[33][33];

        dp[1][1] = 1;

        for(int i=1; i<31; i++){
            for(int j=1; j<i+1; j++){
                if(j == i || j == 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }

        

        int sum = 0;

        for(int i=0; i<W; i++){
            for(int j=0; j<i+1; j++){
                sum += dp[R+i][C+j];
            }
        }

        System.out.println(sum);
        
    }
}