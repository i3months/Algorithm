import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dr = {-1,1,0,0}    ;
    static int[] dc = {0,0,-1,1};

    static char[][] map;
    static boolean visit[][];

    static int max;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        // visit = new boolean[N][M];             

        for(int i=0; i<N; i++){
            for(int j=0; j<M ;j++){
                visit = new boolean[N][M];
                
                if(map[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(max);

    }

    static void bfs(int r, int c){
        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(r,c,0));           

        visit[r][c] = true;        

        while(!q.isEmpty()){
            Locate cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1){
                    continue;
                }

                if(visit[nextR][nextC]){
                    continue;
                }

                if(map[nextR][nextC] == 'W'){
                    continue;
                }

                q.add(new Locate(nextR, nextC, cur.time + 1));
                visit[nextR][nextC] = true;
                
                max = Math.max(cur.time + 1, max);

            }
        }
        
            
        
    }
}

class Locate{
    int r,c, time;
    Locate(int r, int c, int time){
        this.r = r;
        this.c = c;
        this.time = time;
    }
}