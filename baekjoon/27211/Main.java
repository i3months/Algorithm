import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                              

        int n, m;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Queue<Locate> q = new LinkedList<>();

        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());                
            }
        }
        int ans = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0 && !visit[i][j]) {                        
                    ans++;
                    q.add(new Locate(i, j));
                    visit[i][j] = true;

                    while(!q.isEmpty()) {
                        Locate cur = q.poll();                        

                        for(int a=0; a<4; a++) {
                            int nextR = cur.r + dr[a];
                            int nextC = cur.c + dc[a];
                            if(nextR == n) nextR = 0;                            
                            if(nextC == m) nextC = 0;
                            if(nextR == -1) nextR = n-1;
                            if(nextC == -1) nextC = m-1;                        

                            if(map[nextR][nextC] == 1) continue;
                            if(visit[nextR][nextC]) continue;
                            
                            visit[nextR][nextC] = true;
                            q.add(new Locate(nextR, nextC));
                        }

                    }


                }
            }
        }

        System.out.println(ans);
        

        
        
        
        
    }
    static class Locate {
        int r, c;
        Locate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
