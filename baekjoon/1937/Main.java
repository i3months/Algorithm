import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static int N;
    static int[][] map;
    static int[][] visit;
    static int[][] dp;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new int[N][N];
        dp = new int[N][N];        

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                max = Math.max(max,bfs(i,j));
            }
        }

        
        System.out.println(max);

    }

    static int bfs(int r, int c){
        if(dp[r][c] != 0){            
            return dp[r][c];
        }

        dp[r][c] = 1;
                   
        for(int i=0; i<4; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
                continue;
            }

            if(map[r][c] < map[nextR][nextC]){
                dp[r][c] = Math.max(dp[r][c], bfs(nextR,nextC) + 1);
                // bfs(nextR,nextC);
            }
        }

        return dp[r][c];

        // while(!q.isEmpty()){
        //     Locate cur = q.poll();
            
        //     int curR = cur.r;
        //     int curC = cur.c;

        //     max = Math.max(max, visit[curR][curC]);

        //     for(int i=0; i<4; i++){
        //         int nextR = curR + dr[i];
        //         int nextC = curC + dc[i];

        //         if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
        //             continue;
        //         }

        //         if(map[nextR][nextC] <= map[curR][curC]){
        //             continue;
        //         }

        //         if(dp[nextR][nextC] >= visit[nextR][nextC]){
        //             continue;
        //         }

        //         if(visit[nextR][nextC] == Integer.MAX_VALUE){
        //             visit[nextR][nextC] = visit[curR][curC] + 1;                    
        //             dp[nextR][nextC] = Math.max(dp[nextR][nextC], visit[nextR][nextC]);
        //             q.add(new Locate(nextR, nextC));
        //         }else{
        //             // what should i do?
        //         }

                
        //     }
            
        // }

    }
}

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r = r;
        this.c = c;
    }
}