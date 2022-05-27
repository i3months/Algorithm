import java.util.*;
import java.io.*;

public class bfsdfs {

    static int N;
    static int M;    
    static int ans;

    static int[][] map;
    static boolean[][] visit; 
    static int[][] dist;

    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        dist = new int[N+1][M+1];

        for(int i=1; i<N+1; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j+1] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        bfs(1,1);
        System.out.println(dist[N][M]);


        
    }

    static void bfs(int r, int c){

        for(int i=1; i<N+1; i++){
            for(int j=1; j<M+1; j++){
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(r);
        q.add(c);
        dist[r][c] = 1;
        visit[r][c] = true;

        while(!q.isEmpty()){
            int r1 = q.poll();
            int c1 = q.poll();
            for(int i=0; i<4; i++){                
                int nr = r1 + dir[i][0];
                int nc = c1 + dir[i][1];
                if(nr < 1 || nr > N || nc < 1 || nc > M){
                    continue;
                }
                if(map[nr][nc] == 0){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }

                q.add(nr);
                q.add(nc);
                visit[nr][nc] = true;
                dist[nr][nc] = dist[r1][c1] + 1;
            }
        }


    }
}