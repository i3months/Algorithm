import java.util.*;
import java.io.*;

public class Main {

    static int I;    
    static int ans;

    static int[][] map;
    static boolean[][] visit;   
    static int[][] dist;

    static int[][] dir = {{2,-1}, {2,1}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {-1,-2}, {-1,2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visit = new boolean[I][I];
            dist = new int[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());            
            int start_r = Integer.parseInt(st.nextToken());
            int start_c = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int fin_r = Integer.parseInt(st.nextToken());
            int fin_c = Integer.parseInt(st.nextToken());

            bfs(start_r, start_c);

            System.out.println(dist[fin_r][fin_c]);
        }        
                        
    }
    static void bfs(int r, int c){

        for(int i=0; i<I; i++){
            for(int j=0; j<I; j++){
                dist[i][j] = -1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(r);
        q.add(c);
        
        dist[r][c] = 0;
        visit[r][c] = true;

        while(!q.isEmpty()){
            int r1 = q.poll();
            int c1 = q.poll();

            for(int i=0; i<8; i++){
                int nr = r1 + dir[i][0];
                int nc = c1 + dir[i][1];

                if(nr <0 || nr >= I || nc < 0 || nc >= I){
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