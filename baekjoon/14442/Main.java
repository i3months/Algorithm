import java.util.*;
import java.io.*;
 
public class Main {
    
    static int N, M, K;
    static int[][] map;
    static int[][][] visit;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    static int startR, startC;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new int[N][M][K + 1];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0;j <M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }        

        Queue<Locate> q = new LinkedList<>();
        q.add(new Locate(0,0,0));
        visit[0][0][0] = 1;

        while(!q.isEmpty()){
            Locate cur = q.poll();

            // if(cur.r == N-1 && cur.c == M-1) System.out.println(visit[cur.r][cur.c][cur.k]);

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= -1) continue;                
                
                if(map[nextR][nextC] == 0){
                    if(visit[nextR][nextC][cur.k] != 0) continue;
                    visit[nextR][nextC][cur.k] = visit[cur.r][cur.c][cur.k] + 1;
                    q.add(new Locate(nextR, nextC, cur.k));
                    continue;
                }

                if(map[nextR][nextC] == 1){                    
                    if(cur.k >= K) continue;
                    if(visit[nextR][nextC][cur.k + 1] != 0) continue;
                    visit[nextR][nextC][cur.k + 1] = visit[cur.r][cur.c][cur.k] + 1;
                    q.add(new Locate(nextR, nextC, cur.k + 1));
                }
            }
        }

        int min = 987654321;
        for(int i=0; i<K + 1; i++){
            if(visit[N-1][M-1][i] != 0) min = Math.min(min, visit[N-1][M-1][i]);
        }

        System.out.println(min == 987654321 ? -1 : min);
        
        
    }
}

class Locate{
    int r, c, k;
    Locate(int r, int c, int k){this.r=r;this.c=c; this.k=k;}
}