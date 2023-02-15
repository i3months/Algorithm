import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n, m;
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visit = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int num = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        Queue<Locate> q = new LinkedList<>();
        

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 1 && visit[i][j] == 0) {
                    visit[i][j] = 1;
                    q.add(new Locate(i, j));

                    int cnt = 1;
                    num++;

                    while(!q.isEmpty()) {
                        Locate cur = q.poll();

                        for(int a=0; a<4; a++) {
                            int nextR = cur.r + dr[a];
                            int nextC = cur.c + dc[a];
                            
                            if(nextR >= n || nextR <= -1 || nextC >= m || nextC <= -1) continue;
                            if(map[nextR][nextC] == 0) continue;
                            if(visit[nextR][nextC] != 0) continue;

                            visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
                            cnt++;
                            q.add(new Locate(nextR, nextC));
                        }
                    }

                    max = Math.max(max, cnt);
                }
            }
        }
        

        System.out.println(num);
        System.out.println(max);
        

    }

    static class Locate {
        int r, c;

        Locate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
