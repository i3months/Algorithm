import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int wall;
    static int ans;

    static int[][] map;
    static boolean[][] visit;
    static int[][] able_wall;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        able_wall = new int[N * M + 1][2];
        visit = new boolean[N+1][M+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // find available wall

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(map[i][j] == 0){
                    wall++;
                    able_wall[wall][0] = i;
                    able_wall[wall][1] = j;
                }
            }
        }

        dfs(1,0); // install wall        

        System.out.println(ans);
                
    }

    static void bfs(){ // brute force
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                visit[i][j] = false;
                if(map[i][j] == 2){
                    q.add(i);
                    q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();

            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr < 1 || nc < 1 || nr > N || nc > M){
                    continue;
                }
                if(map[nr][nc] != 0){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }

                visit[nr][nc] = true;
                q.add(nr);
                q.add(nc);
            }
        }

        int cnt = 0;

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                if(!visit[i][j] && map[i][j] == 0){
                    cnt++;
                }
            }
        }
        

        ans = Math.max(cnt, ans);
    }

    static void dfs(int idx, int wall_cnt){
        if(wall_cnt == 3){
            bfs();
            return;
        }

        if(idx > wall){
            return;
        }

        map[able_wall[idx][0]][able_wall[idx][1]] = 1;
        dfs(idx+1, wall_cnt+1);
        map[able_wall[idx][0]][able_wall[idx][1]] = 0;
        dfs(idx+1, wall_cnt);

        
    }
}