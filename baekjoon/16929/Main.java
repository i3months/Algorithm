import java.util.*;
import java.io.*;
 
public class Main {
    
    static int N, M;
    static char[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int startR, startC;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
     
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visit = new boolean[N][M];
                startR = i;
                startC = j;
                if(dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        
        System.out.println("No");
    }
    
    public static boolean dfs(int x, int y, int count) {        
        visit[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nextR = x + dx[i];
            int nextC = y + dy[i];
            
            if(nextR >= 0 && nextC >= 0 && nextR < N && nextC < M && map[x][y] == map[nextR][nextC]) {
                if(visit[nextR][nextC] == false) {
                    visit[nextR][nextC] = true;
                    if(dfs(nextR, nextC, count + 1)) return true;
                } else {
                    if(count >= 4 && startR == nextR && startC == nextC) return true;
                }
            }
        }
        return false;
    }
}
