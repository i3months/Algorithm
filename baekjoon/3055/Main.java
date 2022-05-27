import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int M;
    static char[][] map;
    
    
    static int[][] dist_water;
    static int[][] dist_hedgehog;
    static boolean[][] visit;

    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};    
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
        visit = new boolean[N][M];
        
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        bfs_water();
        bfs_hedgehog();

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){                                    
                if(map[i][j] == 'D'){
                    if(dist_hedgehog[i][j] == -1){
                        System.out.println("KAKTUS");
                    }else{
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
        
        
    }

    static void bfs_water(){

        visit = new boolean[N][M];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dist_water[i][j] = -1;
                if(map[i][j] == '*'){
                    q.add(i);
                    q.add(j);
                    dist_water[i][j] = 0;
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
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(map[nr][nc] != '.'){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                q.add(nr);
                q.add(nc);
                visit[nr][nc] = true;
                dist_water[nr][nc] = dist_water[r][c] + 1;
            }
        }
    }

    static void bfs_hedgehog(){
        Queue<Integer> q = new LinkedList<>();

        visit = new boolean[N][M];    

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dist_hedgehog[i][j] = -1;
                if(map[i][j] == 'S'){
                    q.add(i);
                    q.add(j);
                    dist_hedgehog[i][j] = 0;
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
                if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                    continue;
                }
                if(map[nr][nc] != '.' && map[nr][nc] != 'D'){
                    continue;
                }
                if(dist_water[nr][nc] != -1 && dist_water[nr][nc] <= dist_hedgehog[r][c] + 1){
                    continue;
                }
                if(visit[nr][nc]){
                    continue;
                }
                q.add(nr);
                q.add(nc);
                visit[nr][nc] = true;
                dist_hedgehog[nr][nc] = dist_hedgehog[r][c] + 1;
            }
        }
    }
}