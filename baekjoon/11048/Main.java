import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];

        for(int i=1; i<N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M + 1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                int cmp1 = dp[i-1][j] + map[i][j];
                int cmp2 = dp[i-1][j-1] + map[i][j];
                int cmp3 = dp[i][j-1] + map[i][j];

                dp[i][j] = Math.max(cmp1, Math.max(cmp2, cmp3));
            }
        }

        System.out.println(dp[N][M]);
        

        
    }
}