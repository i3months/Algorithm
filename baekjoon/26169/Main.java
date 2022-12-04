import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;

    static int[][] map = new int[6][6];
    static int[][] visit = new int[6][6];

    static int R, C;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int ans = INF; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=1; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<6; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visit[R+1][C+1] = 1;

        solve(R+1, C+1, 0);

        System.out.println(0);
        // if(ans == INF) System.out.println(-1);
        // else System.out.println(ans - 1);
    }

    static void solve(int r, int c, int apple) {
        if(apple == 2) {
            if(visit[r][c] <= 4) {
                System.out.println(1);
                System.exit(0);
            }
            ans = Math.min(ans, visit[r][c]);
            // System.out.println(ans);
            return;
        }

        for(int i=0; i<4; i++) {

            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= 6 || nextR <= 0 || nextC >= 6 || nextC <= 0) continue;
            if(visit[nextR][nextC] != 0) continue;                
            if(map[nextR][nextC] == -1) continue;
            
            visit[nextR][nextC] = visit[r][c] + 1;            
            if(map[nextR][nextC] == 1) solve(nextR, nextC, apple + 1);
            else solve(nextR, nextC, apple);
            visit[nextR][nextC] = 0;            
            
        }

    }
}