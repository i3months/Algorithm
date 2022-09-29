import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())    ;

        int[][] arr = new int[N + 1][4];

        for(int i=1; i<N+1; i++){
            StringTokenizer st=  new StringTokenizer(br.readLine());

            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][4];
        int[][] dp2 = new int[N+1][4];

        dp2[1][1] = dp[1][1] = arr[1][1];
        dp2[1][2] = dp[1][2] = arr[1][2];
        dp2[1][3] = dp[1][3] = arr[1][3];

        for(int i=2; i<N+1; i++){
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i][1];
            dp[i][2] = Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])) + arr[i][2];
            dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3]) + arr[i][3];

            dp2[i][1] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][1];
            dp2[i][2] = Math.min(dp2[i-1][1], Math.min(dp2[i-1][2], dp2[i-1][3])) + arr[i][2];
            dp2[i][3] = Math.min(dp2[i-1][2], dp2[i-1][3]) + arr[i][3];
        }

        System.out.println(Math.max(dp[N][1], Math.max(dp[N][2], dp[N][3])) + " " + Math.min(dp2[N][1], Math.min(dp2[N][2], dp2[N][3])));

        
    }
}