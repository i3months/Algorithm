import java.util.*;
import java.io.*;
import java.math.*;

public class Main {        
    static int INF = 123456789;

    static int dr[] = {1,0};
    static int dc[] = {0,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken())      ;
        int M = Integer.parseInt(st.nextToken());

        int mod = 100000;

        long[][][] dp = new long[N + 1][M + 1][4];

        for(int i=1; i<N+1; i++){
            dp[i][1][0] = 1;
        }

        for(int j=1; j<M+1; j++){
            dp[1][j][2] = 1;
        }

        for(int i=2; i<N+1; i++){
            for(int j=2; j<M+1; j++){
                dp[i][j][0] = dp[i-1][j][1] + dp[i-1][j][0];
                dp[i][j][0] %= mod;

                dp[i][j][1] = dp[i-1][j][2];

                dp[i][j][2] = dp[i][j-1][3] + dp[i][j-1][2];
                dp[i][j][2] %= mod;
                dp[i][j][3] = dp[i][j-1][0];

            }
        }
        int sum=0;
        for(int i=0; i<4; i++){
            sum += dp[N][M][i];
        }
        System.out.println(sum %=mod);
    }
}