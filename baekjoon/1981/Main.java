import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    static int n;
    static int map[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxValue = -1;
    static int minValue = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        int ans = -1;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {                
                map[i][j] = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, map[i][j]);
                minValue = Math.min(minValue, map[i][j]);
            }  
        }
        
        int left = 0;
        int right = maxValue - minValue;
        
        while(left <= right) {
            int mid = (left + right) / 2;

            boolean flag = false;            

            loop : for(int a=minValue; a<maxValue+1; a++) {
                Queue<Locate> q = new LinkedList<>();
                boolean[][] visit = new boolean[n+1][n+1];

                for(int i=0; i<n; i++) Arrays.fill(visit[i], true);
                

                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        if(a <= map[i][j] && map[i][j] <= a + mid) {
                            visit[i][j] = false;
                        }       
                    }
                }

                q.add(new Locate(0,0));

                while(!q.isEmpty()) {
                    Locate cur = q.poll();

                    int curR = cur.r;
                    int curC = cur.c;

                    if(visit[curR][curC]) continue;
                    visit[curR][curC] = true;

                    if(curR == n-1 && curC == n-1) {
                        flag = true;
                        break loop;
                    }

                    for(int i=0; i<4; i++) {
                        int nextR = curR + dr[i];
                        int nextC = curC + dc[i];

                        if(nextR >= n || nextR <= -1 || nextC >= n || nextC <= -1) continue;
                        q.add(new Locate(nextR, nextC));
                    }
                }
            }            

            if(flag) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
            

        }

        System.out.println(ans);
        


    }
}

class Locate {
    int r, c;
    Locate(int r, int c) {
        this.r = r; this.c = c;
    }
}
