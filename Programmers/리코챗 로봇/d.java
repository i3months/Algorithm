import java.util.*;

class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int startX = 0, startY = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], moves = cur[2];
            
            if (board[x].charAt(y) == 'G') {
                return moves;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while (true) {
                    int nextX = nx + dx[i];
                    int nextY = ny + dy[i];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) break;
                    if (board[nextX].charAt(nextY) == 'D') break;
                    nx = nextX;
                    ny = nextY;
                }
                if (nx == x && ny == y) continue;
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moves + 1});
                }
            }
        }
        return -1;
    }
}
