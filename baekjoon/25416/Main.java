import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[][] map = new int[5][5];    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int destinationR = 0;
    static int destinationC = 0;

    static int[][] visit = new int[5][5];

    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    destinationR = i;
                    destinationC = j;
                }
                visit[i][j] = -1;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());        

        Queue<Locate> q = new LinkedList<>();

        q.add(new Locate(r,c));

        int ans = Integer.MAX_VALUE;

        // for(int i=0; i<5; i++){
        //     for(int j=0; j<5; j++){
        //         System.out.print(visit[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        visit[r][c] = 0;

        ////
        while(!q.isEmpty()){
            Locate cur = q.poll();         
            
            if(cur.r == destinationR && cur.c == destinationC){
                ans = Math.min(ans, visit[cur.r][cur.c]);
            }          

            for(int i=0; i<4; i++){
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR >= 5 || nextR <= -1 || nextC >= 5 || nextC <= -1){
                    continue;
                }  

                if(map[nextR][nextC] == -1){
                    continue;
                }

                if(visit[nextR][nextC] == -1){
                    visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                    q.add(new Locate(nextR, nextC));
                }else{
                    if(visit[nextR][nextC] > visit[cur.r][cur.c] + 1){
                        visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                        q.add(new Locate(nextR, nextC));
                    }
                }
            }

        }
        ////

        // for(int i=0; i<5; i++){
        //     for(int j=0; j<5; j++){
        //         System.out.print(visit[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        
    }
}

class Locate{
    int r,c;
    int cnt = 0;
    Locate(int r, int c){
        this.r = r;
        this.c = c;        
    }
}