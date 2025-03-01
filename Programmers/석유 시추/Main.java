import java.util.*;

class Solution {
    static int n, m, maxCnt;        
    
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    private static List<Set<Integer>> way = new ArrayList<>();
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        
        int[] oilCnt = new int[1_000_000];
        
        boolean[][] visited = new boolean[n][m];
        int oilIdx = 2;
        
        for (int i=0;i <m; i++) way.add(new HashSet<>());
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (visited[i][j]) continue;
                if (land[i][j] != 1) continue;
                
                oilIdx++;
                visited[i][j] = true;
                
                land[i][j] = oilIdx;
                oilCnt[oilIdx]++;
                
                Queue<Locate> q = new LinkedList<>();
                
                q.add(new Locate(i,j));
                way.get(j).add(oilIdx);
                
                while(!q.isEmpty()) {
                    Locate curLocate = q.poll();
                    
                    for(int k=0; k<4; k++) {
                        int nextR = curLocate.r + dr[k];
                        int nextC = curLocate.c + dc[k];
                        
                        if (isValid(nextR, nextC) && !visited[nextR][nextC] && land[nextR][nextC] == 1) {
                            q.add(new Locate(nextR, nextC));
                            visited[nextR][nextC] = true;
                            land[nextR][nextC] = oilIdx;
                            oilCnt[oilIdx]++;
                            way.get(nextC).add(oilIdx);
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            int curCnt = 0;
            Set<Integer> curWay = way.get(i);
            for(int idx : curWay) {
                curCnt += oilCnt[idx];
            }
            maxCnt = Math.max(maxCnt, curCnt);
        }
        
        
        
//         for(int i=0; i<m; i++) {
//             int curCnt = 0;
//             boolean[] curVisited = new boolean[1_000_000];
//             for(int j=0; j<n; j++) {
//                 if (land[j][i] == 0) continue;
//                 if (curVisited[land[j][i]]) continue;
                
//                 curVisited[land[j][i]] = true;
//                 curCnt += oilCnt[land[j][i]];
                
//             }
            
//             maxCnt = Math.max(maxCnt, curCnt);
//         }
  
        
        return maxCnt;
    }
    
    static boolean isValid(int r, int c) {
        if (0 <= r && r < n && 0 <= c && c < m) return true;
        return false;
    }
}

class Locate {
    int r,c;
    Locate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}