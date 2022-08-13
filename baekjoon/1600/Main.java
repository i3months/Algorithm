import java.util.*;
import java.io.*;
import java.math.*;

public class Main { 
    static int[][] map;
    static int K, N, M;

    static int ans = -1;
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] hr = {-2,-2,-1,-1,1,1,2,2};
    static int[] hc = {-1,1,-2,2,-2,2,-1,1};

    static boolean[][][] visit;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M][K + 1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        ans = bfs(0,0);

        System.out.println(ans);

        

        
    }

    static int bfs(int r, int c){
        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(r,c,0,K));
        visit[r][c][K] = true;

        while(!q.isEmpty()){
            Locate cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;

            if(curR == N - 1 && curC == M - 1){
                // System.out.println("asdf");
                return cur.cnt;
            }

            for(int i=0; i<4; i++){
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];

                if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1){
                    continue;
                }

                if(visit[nextR][nextC][cur.k]){
                    continue;
                }

                if(map[nextR][nextC] == 1){
                    continue;
                }

                visit[nextR][nextC][cur.k] = true;
                q.add(new Locate(nextR, nextC, cur.cnt + 1, cur.k));
                
            }

            if(cur.k > 0){
                for(int i=0; i<8; i++){
                    int nextR = curR + hr[i];
                    int nextC = curC + hc[i];

                    if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1){
                        continue;
                    }
                    
                    if(visit[nextR][nextC][cur.k - 1]){
                        continue;
                    }
    
                    if(map[nextR][nextC] == 1){
                        continue;
                    }

                    visit[nextR][nextC][cur.k - 1] = true;
                    q.add(new Locate(nextR, nextC, cur.cnt + 1, cur.k - 1));
                    
                }
            }
        }

        return ans;
        
    }
}

class Locate{
    int r,c,cnt,k;

    Locate(int r, int c, int cnt, int k){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.k = k;
    }
}