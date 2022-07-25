import java.util.*;
 
public class Main {
    
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean[][] visited;
    static ArrayList<Point> list;

    static int n = 12, m = 6;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String field = scan.nextLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = field.charAt(j); 
            }
        }
        
        int count = 0;
        
        while(true) {
            boolean isFinished = true;
            visited = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(map[i][j], i, j);
                        
                        if(list.size() >= 4) {
                            isFinished = false; 
                            for(int k = 0; k < list.size(); k++) {
                                map[list.get(k).x][list.get(k).y] = '.'; 
                            }
                        }
                    }
                }
            }
            if(isFinished) break;
            fallPuyos(); 
            count++;
        }
        System.out.println(count);
    }
    
    public static void fallPuyos() {        
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public static void bfs(char c, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list.add(new Point(x, y));
        q.offer(new Point(x, y));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Point current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dr[i];
                int ny = current.y + dc[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false && map[nx][ny] == c) {
                    visited[nx][ny] = true;
                    list.add(new Point(nx, ny));
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
 
    public static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}    
