import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    static int[][] map;    

    static int max;

    static int highest;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        N = Integer.parseInt(br.readLine());

        map = new int[N][N]; 

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(highest, map[i][j]);
            }
        }

        for(int i=0; i<highest; i++){
            max = Math.max(max, bfs(i));
        }

        System.out.println(max);
        


        
    }

    static int bfs(int rain){
        int[][] map2 = new int[N][N];
        boolean[][] visit = new boolean[N][N];        

        for(int i=0; i<N; i++){ // 잠기는지역 1 안잠기는지역 0
            for(int j=0; j<N; j++){
                if(map[i][j] <= rain){
                    map2[i][j] = 1;
                }
            }            
        }

        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                
                if(!visit[i][j] && map2[i][j] == 0){
                    Queue<Locate> q = new LinkedList<>();
                    cnt++;
                    q.add(new Locate(i,j));
                    visit[i][j] = true;

                    while(!q.isEmpty()){
                        Locate cur = q.poll();

                        for(int k=0; k<4; k++){
                            int nextR = cur.r + dr[k];
                            int nextC = cur.c + dc[k];

                            if(nextR >= N || nextR <= -1 || nextC >= N || nextC <= -1){
                                continue;
                            }

                            if(map2[nextR][nextC] == 1){
                                continue;
                            }

                            if(visit[nextR][nextC]){
                                continue;
                            }

                            visit[nextR][nextC] = true;
                            q.add(new Locate(nextR, nextC));

                            
                        }
                    }
                    
                    
                }

            }
        }

        return cnt;
        
    }
}

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r =r;
        this.c = c;
    }
}