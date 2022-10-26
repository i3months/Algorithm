import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        Locate start = null;        

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0'){
                    start = new Locate(i, j, 0);
                }
            }
        }

        int[][][] visit = new int[N][M][1<<7];
        
        Queue<Locate> q = new LinkedList<>();
        visit[start.r][start.c][0] = 1;
        q.add(start);

        int min = 987654321;

        while(!q.isEmpty()){
            Locate cur = q.poll();      
            
            // System.out.println(cur.r + " " + cur.c + " " + cur.key);

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= N || nextR <= -1 || nextC >= M || nextC <= - 1) continue;
                if(visit[nextR][nextC][cur.key] != 0) continue;
                if(map[nextR][nextC] == '#') continue;
                
                if(map[nextR][nextC] == '1'){
                    visit[nextR][nextC][cur.key] = visit[cur.r][cur.c][cur.key] + 1;
                    min = Math.min(min, visit[nextR][nextC][cur.key]);                    
                    continue;
                }

                if(map[nextR][nextC] >= 'a' && map[nextR][nextC] <= 'f'){
                    int temp = map[nextR][nextC] - 'a';                    
                    int cmp = 1 << temp;

                    int nextKey = cur.key | cmp;

                    visit[nextR][nextC][nextKey] = visit[cur.r][cur.c][cur.key] + 1;
                    q.add(new Locate(nextR, nextC, nextKey));
                    continue;
                }

                if(map[nextR][nextC] >= 'A' && map[nextR][nextC] <= 'F'){
                    int temp = map[nextR][nextC] - 'A';
                    int cmp = 1 << temp;

                    int door = cur.key & cmp;

                    if(door != 0){
                        visit[nextR][nextC][cur.key] = visit[cur.r][cur.c][cur.key] + 1;
                        q.add(new Locate(nextR, nextC, cur.key));
                    }
                    continue;
                }

                visit[nextR][nextC][cur.key] = visit[cur.r][cur.c][cur.key] + 1; 
                q.add(new Locate(nextR, nextC, cur.key));
                

            }
        }

        System.out.println(min == 987654321 ? -1 : min-1);
        
        
        
    }
}

class Locate{
    int r, c;
    int key = 0;
    Locate(int r,int c){this.r=r;this.c=c;}
    Locate(int r, int c, int key){this.r=r;this.c=c;this.key=key;}
}