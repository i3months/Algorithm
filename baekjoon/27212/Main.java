import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    
    static StringBuilder sb = new StringBuilder(); 
    static long[][] dp;
    static int[][] satisfy;    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                              

        int n, m, c;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] univA = new int[n+1];
        int[] univB = new int[m+1];

        int[][] w = new int[c+1][c+1];
        satisfy = new int[n+1][m+1];
        dp = new long[n+1][m+1];

        for(int i=1; i<c+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<c+1; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());            
            }
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) univA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<m+1; i++) univB[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                satisfy[i][j] = w[univA[i]][univB[j]];
            }
        }
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + satisfy[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        System.out.println(dp[n][m]);
        
        
    }
}
