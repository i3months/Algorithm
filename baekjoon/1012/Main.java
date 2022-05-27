import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int M;
    static int K;
    static int[][] map;
        
    static boolean[][] visit;

    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};    

    static int cnt;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());        

        StringBuilder sb = new StringBuilder();

        for(int m = 0; m<T; m++){
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new boolean[N][M];

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
    
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
    
                map[b][a] = 1;
            }
            
            for(int i=0; i<N; i++){
                for(int j=0;j<M; j++){
                    if(!visit[i][j] && map[i][j] == 1){                        
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
    
            sb.append(cnt+"\n");            
        }

        System.out.print(sb);
        
    }

    static void dfs(int r, int c){        
        visit[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }
            if(map[nr][nc] == 0){
                continue;
            }
            if(visit[nr][nc]){
                continue;
            }
            dfs(nr, nc);
        }
    }
}