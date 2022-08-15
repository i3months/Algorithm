import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[]  visit;
    static int min = Integer.MAX_VALUE;

    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        dfs(0,0);

        System.out.println(ans);

        
    }

    static void dfs(int r, int c){
        if(r == N){
            for(int i=0; i<N - 1; i++){
                for(int j=0; j<M-1; j++){
                    if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]){
                        return;
                    }
                }
            }

            ans++;
            return;
        }

        int nextC = (c + 1 == M) ? 0 : c + 1;
        int nextR =  (nextC == 0) ? r + 1 : r;
        
        map[r][c] = true;
        dfs(nextR, nextC);
        map[r][c] = false;
        dfs(nextR, nextC);
    }
}