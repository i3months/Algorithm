import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visit;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int count = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
        

    }

    static int dfs(int r, int c){
        if(r == N-1 && c == M - 1){
            return 1;
        }

        if(dp[r][c] != -1){
            return dp[r][c];
        }

        dp[r][c] = 0;

        for(int i=0; i<4; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1){
                continue;
            }

            if(map[r][c] > map[nextR][nextC]){
                dp[r][c] = dp[r][c] + dfs(nextR, nextC);
            }
        }

        return dp[r][c];
    }
}

class Locate {
    int r, c;

    Locate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}