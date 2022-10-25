import java.io.*;
import java.util.*;
 
public class Main {
    
    static int R, C;
    static char[][] map;
    static boolean[][] visit;
    static int[] dr = {-1,0,1};
    static int[] dc = {1,1,1};

    static int ans = 0;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            flag = false;
            dfs(i,0);
        }

        System.out.println(ans);

        
        
    }

    static void dfs(int r, int c){
        visit[r][c] = true;

        if(c == C - 1){
            ans++;
            flag = true;
            return;
        }

        for(int i=0; i<3; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= R || nextR <= -1 || nextC >= C || nextC <= -1) continue;
            if(map[nextR][nextC] == 'x') continue;
            if(visit[nextR][nextC]) continue;

            dfs(nextR, nextC);

            if(flag) return;
        }
    }
}