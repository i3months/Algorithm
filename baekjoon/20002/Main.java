import java.util.*;
import java.io.*;
import java.math.*;

public class Main {        
    static int INF = 123456789;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        int[][] dp = new int[N+1][N+1];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        int max = -1;

        for(int k=0; k<N; k++){
            for(int i=1; i<N-k+1; i++){
                for(int j=1; j<N-k+1; j++){
                    int tmp = dp[i+k][j+k] - dp[i-1][j+k] - dp[i+k][j-1] + dp[i-1][j-1];
                    max = Math.max(max, tmp);
                }
            }
        }

        System.out.println(max);
        
        
    }   
}