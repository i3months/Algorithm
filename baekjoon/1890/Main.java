import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int cnt;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        long[][] dp = new long[N+1][N+1];
        dp[0][0] = 1;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == N-1 && j == N-1){
                    continue;
                }
                int num = map[i][j];

                if( i + num < N){
                    dp[i + num][j] += dp[i][j];
                }

                if(j + num < N){
                    dp[i][j + num] += dp[i][j];
                 }
            }
        }

        System.out.println(dp[N-1][N-1]);
        
        
    }

    static void bt(int r, int c){
        if(r == N-1 && c == N-1){
            cnt++;
            return;
        }

        int num = map[r][c];
        
        int nextR = r + num;
        int nextC = c;

        if(!(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1)){
            bt(nextR, nextC);
        }

        nextR = r;
        nextC = c + num;

        if(!(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1)){
            bt(nextR, nextC);
        }

    }
}
