import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int[][] map;
    static boolean visit[][];

    static int min =Integer.MAX_VALUE;

    static ArrayList<Locate> island;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());        

        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }              

        visit = new boolean[N][N];

        int color = 1;        

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0 && !visit[i][j]){
                    island = new ArrayList<>();
                    bfs(i,j);
                    fill_map(color);
                    color++;                    
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(map[i][j] != 0){
                    int curR = i;
                    int curC = j;

                    for(int k=0; k<4; k++){
                        int nextR = curR + dr[k];
                        int nextC = curC + dc[k];

                        if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
                            continue;
                        }

                        if(map[nextR][nextC] == 0){
                            int tmp_color = map[i][j];
                            bfs2(i,j, tmp_color);
                            break;
                        }
                        

                    }
                }                     

            }
        }

        System.out.println(min);
       

        

    } 
    
    static void bfs2(int r, int c, int color){
        Queue<Locate> q = new LinkedList<>();

        visit = new boolean[N][N];
        q.add(new Locate(r, c,0));
        visit[r][c] = true;

        while(!q.isEmpty()){
            Locate cur = q.poll();

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >=  N || nextR <= -1 || nextC >= N || nextC <= -1){
                    continue;
                }

                if(visit[nextR][nextC]){
                    continue;
                }

                if(map[nextR][nextC] == color){
                    continue;
                }

                if(map[nextR][nextC] != 0){
                    min = Math.min(min, cur.time);
                }

                visit[nextR][nextC] = true;
                q.add(new Locate(nextR, nextC, cur.time + 1));                

                
            }
        }
        
    }

    static void fill_map(int color){        
        for(Locate locate : island){
            int r = locate.r;
            int c = locate.c;
            map[r][c] = color;
        }
    }
    
    static void bfs(int r, int c){
        Queue<Locate> q = new LinkedList<>();

        island.add(new Locate(r,c));
        visit[r][c] = true;
        q.add(new Locate(r,c));
        
        while(!q.isEmpty()){
            Locate cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
                    continue;
                }

                if(visit[nextR][nextC]){
                    continue;
                }

                if(map[nextR][nextC] == 0){
                    continue;
                }

                visit[nextR][nextC] = true;
                q.add(new Locate(nextR, nextC));
                island.add(new Locate(nextR, nextC));
            }
        }
        
    
    }
}

class Locate{
    int r,c,time;

    Locate(int r, int c){
        this.r = r;
        this.c = c;        
    }

    Locate(int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }
}