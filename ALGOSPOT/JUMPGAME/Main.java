import java.io.*;
import java.util.*;

public class Main {    
    static final int INF = 987654321;  

    static int N;
    static int[][] map;
    static int[][] dp;

    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];
            dp = new int[N+1][N+1];
            
            flag = false;

            for(int i=1; i<N+1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<N+1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N+1; i++) Arrays.fill(dp[i], -1);

            solve(1,1);

            if(flag) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            
        }


    }
    
    static int solve(int r, int c) {
        if(r >= N+1 || c >= N+1 ) return 0;
        if(r == N && c == N) {
            flag = true;
            return 1;
        }

        if(dp[r][c] != -1) return dp[r][c];
        int size = map[r][c];

        int a = solve(r+size, c);
        int aa = solve(r, c+size);
        
        if(a == 1 || aa == 1) {
            dp[r][c] = 1;
        } else {
            dp[r][c] = 0;
        }

        return dp[r][c];
        // dp[r][c] = solve(r+size, c) || solve(r, c+size);
    }
}