import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();      
    static final int INF = 987654321;  

    static int n;
    static char[][] map;
    static int visit[][][];
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Node start = null, end = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visit = new int[n][n][4];        

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {                
                map[i][j] = str.charAt(j);
                
                if(map[i][j] == '#') {
                    if(start == null) start = new Node(i, j, 0);
                    else end = new Node(i, j, 0);
                }

                for(int k=0; k<4; k++) visit[i][j][k] = INF;
                
            }
        }

        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i<4; i++) {
            Node node = new Node(start.r, start.c, i);

            q.add(node);
            visit[start.r][start.c][i] = 0;

            while(!q.isEmpty()) {
                Node curNode = q.poll();
                
                int nextR = curNode.r + dr[curNode.dir];
                int nextC = curNode.c + dc[curNode.dir];

                int nextDir1 = -1;
                int nextDir2 = -1;

                if(curNode.dir == 0 || curNode.dir == 1) {
                    nextDir1 = 2; nextDir2 = 3;
                }

                if(curNode.dir == 2 || curNode.dir == 3) {
                    nextDir1 = 0; nextDir2 = 1;
                }

                if(nextR >= n || nextC >= n || nextR <= -1 || nextC <= -1) continue;
                if(map[nextR][nextC] == '*') continue;
                if(map[nextR][nextC] == '!') {
                    if(visit[nextR][nextC][curNode.dir] > visit[curNode.r][curNode.c][curNode.dir]) {
                        visit[nextR][nextC][curNode.dir] = visit[curNode.r][curNode.c][curNode.dir];
                        q.add(new Node(nextR, nextC, curNode.dir));
                    }
                    if(visit[nextR][nextC][nextDir1] > visit[curNode.r][curNode.c][curNode.dir] + 1) {
                        visit[nextR][nextC][nextDir1] = visit[curNode.r][curNode.c][curNode.dir] + 1;
                        q.add(new Node(nextR, nextC, nextDir1));
                    }
                    if(visit[nextR][nextC][nextDir2] > visit[curNode.r][curNode.c][curNode.dir] + 1) {
                        visit[nextR][nextC][nextDir2] = visit[curNode.r][curNode.c][curNode.dir] + 1;
                        q.add(new Node(nextR, nextC, nextDir2));
                    }                    
                }
                if(map[nextR][nextC] == '.') {
                    if(visit[nextR][nextC][curNode.dir] > visit[curNode.r][curNode.c][curNode.dir]) {
                        visit[nextR][nextC][curNode.dir] = visit[curNode.r][curNode.c][curNode.dir];
                        q.add(new Node(nextR, nextC, curNode.dir));
                    }                    
                }
                if(map[nextR][nextC] == '#') {
                    if(visit[nextR][nextC][curNode.dir] > visit[curNode.r][curNode.c][curNode.dir]) {
                        visit[nextR][nextC][curNode.dir] = visit[curNode.r][curNode.c][curNode.dir];
                    }
                }

            }                        
        }

        int ans = INF;

        for(int i=0; i<4; i++) ans = Math.min(ans, visit[end.r][end.c][i]);            

        System.out.println(ans);
        



    }
}

class Node {
    int r, c, dir;

    Node(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}