import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> qu;
    static int count;
		
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken(" "));
        m = Integer.parseInt(st.nextToken(" "));

        arr = new char[n][m];
        visit = new boolean[n][m];
        qu = new LinkedList<>();
        count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]){
                    bfs(new Point(i,j));
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    private static void bfs(Point point) {
        qu.add(point);
        visit[point.x][point.y] = true;

        while(!qu.isEmpty()){
            Point p = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

                if(arr[p.x][p.y] == '-'){
                    if(arr[p.x][ny] == arr[p.x][p.y] && !visit[p.x][ny]){
                        qu.offer(new Point(p.x, ny));
                        visit[p.x][ny] = true;
                    }
                }else{
                    if(arr[nx][p.y] == arr[p.x][p.y] && !visit[nx][p.y]){
                        qu.offer(new Point(nx, p.y));
                        visit[nx][p.y] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}