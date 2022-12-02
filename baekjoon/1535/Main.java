import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;

    static int[] happy;
    static int[] health;
    
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        N = Integer.parseInt(br.readLine());

        happy = new int[N+1];
        health = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][101];

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<101; j++) {
                if(health[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-health[i]] + happy[i]);
                }
            }
        }
        
        System.out.println(dp[N][99]);
    }
}