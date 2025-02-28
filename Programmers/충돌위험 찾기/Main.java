import java.util.*;

class Solution {
    static List<List<Locate>> list;
    static int x;
    
    public int solution(int[][] points, int[][] routes) {
        x = routes.length;
        list = new ArrayList<>();
        
        for(int i=0; i<x; i++) {
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<x; i++) {
            int[] curPoint = points[routes[i][0] - 1];
            int curR = curPoint[0];
            int curC = curPoint[1];
            
            list.get(i).add(new Locate(curR,curC));
            
            for(int j=1; j<routes[0].length; j++) {
                int[] nextPoint = points[routes[i][j] - 1];
                
                int nextR = nextPoint[0];
                int nextC = nextPoint[1];
                
                int leftR = nextR - curR;
                int leftC = nextC - curC;
                
                while (true) {
                    if (leftR == 0) break;
                    
                    if (leftR > 0) {
                        leftR--;
                        curR++;
                        list.get(i).add(new Locate(curR, curC));    
                    }   
                    
                    else {
                        leftR++;
                        curR--;
                        list.get(i).add(new Locate(curR, curC));    
                    }                                        
                }
                
                while (true) {
                    if (leftC == 0) break;
                    
                    if (leftC > 0) {
                        leftC--;
                        curC++;
                        list.get(i).add(new Locate(curR, curC));    
                    }   
                    
                    else {
                        leftC++;
                        curC--;
                        list.get(i).add(new Locate(curR, curC));    
                    }                                        
                }
                
                
            }
            
        }
        
        int ans = 0;        
        int cnt = 0;        
        
        while(true) {            
            if (cnt == x) break;
            
            int[][] map = new int[101][101];
            cnt = 0;
                        
            for(int i=0; i<x; i++) {
                if (list.get(i).size() == 0) {
                    cnt++;
                    continue;
                }

                Locate curLocate = list.get(i).get(0);
                list.get(i).remove(0);

                map[curLocate.r][curLocate.c]++;            
            }

            for(int i=0; i<101; i++) {
                for(int j=0; j<101; j++) {
                    if(map[i][j] > 1) ans++;
                }
            }   
        }            
        
        
        
        return ans;
        
        
    }
}

class Locate {
    int r,c;
    Locate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}