import java.io.*;
import java.util.*;
import java.math.*;

public class Main {			
	static int INF = 987654321;
    static int[][] map;
    static int[][] visit;
    static int[] dr = {0,0,0,1,-1};
    static int[] dc = {0,1,-1,0,0};
    static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<M+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] fin = new int[3];
        int[] start = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            start[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            fin[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Locate> q = new LinkedList<>();
        int[][][] visit = new int[N+1][M+1][5];

        q.add(new Locate(start[0], start[1], start[2]));
        visit[start[0]][start[1]][start[2]] = 1;

        int min = INF;

        while(!q.isEmpty()){
            Locate cur = q.poll();

            int curR = cur.r;
            int curC = cur.c;
            int curP = cur.p;

            if(curR == fin[0] && curC == fin[1] && curP == fin[2]){
                min = Math.min(min, visit[curR][curC][curP] - 1);
                // System.out.println(visit[curR][curC][curP] - 1);                
            }

            if(curP == 1){
                if(visit[curR][curC][2] == 0){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 2));
                }else if(visit[curR][curC][2] >= visit[curR][curC][curP] + 3){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 2));
                }

                if(visit[curR][curC][3] == 0){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 3));
                }else if(visit[curR][curC][3] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 3));                
                }

                if(visit[curR][curC][4] == 0){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 4));
                }else if(visit[curR][curC][4] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 4));                
                }
            }

            if(curP == 2){
                if(visit[curR][curC][1] == 0){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 1));
                }else if(visit[curR][curC][1] >= visit[curR][curC][curP] + 3){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 1));                
                }

                if(visit[curR][curC][3] == 0){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 3));
                }else if(visit[curR][curC][3] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 3));                
                }

                if(visit[curR][curC][4] == 0){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 4));
                }else if(visit[curR][curC][4] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 4));                
                }
            }

            if(curP == 3){
                if(visit[curR][curC][2] == 0){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 2));
                }else if(visit[curR][curC][2] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 2));                
                }

                if(visit[curR][curC][1] == 0){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 1));
                }else if(visit[curR][curC][1] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 1));                
                }

                if(visit[curR][curC][4] == 0){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 4));
                }else if(visit[curR][curC][4] >= visit[curR][curC][curP] + 3){
                    visit[curR][curC][4] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 4));                
                }
            }

            if(curP == 4){
                if(visit[curR][curC][2] == 0){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 2));
                }else if(visit[curR][curC][2] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][2] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 2));                
                }

                if(visit[curR][curC][3] == 0){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 3));
                }else if(visit[curR][curC][3] >= visit[curR][curC][curP] + 3){
                    visit[curR][curC][3] = visit[curR][curC][curP] + 2;
                    q.add(new Locate(curR, curC, 3));                
                }

                if(visit[curR][curC][1] == 0){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 1));
                }else if(visit[curR][curC][1] >= visit[curR][curC][curP] + 2){
                    visit[curR][curC][1] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(curR, curC, 1));                
                }
            }

            for(int j=1; j<=3; j++){                
                int nextR = curR + (dr[curP] * j);
                int nextC = curC + (dc[curP] * j);
                        
                if(nextR >= N+1 || nextR <= 0 || nextC >= M+1 || nextC <= 0) continue;
                    
                if(visit[nextR][nextC][curP] != 0){
                    continue;
                } else if(visit[nextR][nextC][curP] >= visit[curR][curC][curP] + 2){
                    visit[nextR][nextC][curP] = visit[curR][curC][curP] + 1;
                    q.add(new Locate(nextR, nextC, curP));   
                }

                if(map[nextR][nextC] == 1) break;

                visit[nextR][nextC][curP] = visit[curR][curC][curP] + 1;

                q.add(new Locate(nextR, nextC, curP));                                       
            }            
            
        }

        System.out.println(min);

        // for(int p=1; p<5; p++){
        //     System.out.println("debug" + p);
        //     for(int i=1; i<N+1; i++){
        //         for(int j=1; j<M+1; j++){
        //             System.out.print(visit[i][j][p] + " ");
        //         }System.out.println();
        //     }
        // }
        
	}	
}

class Locate{
    int r,c,p;
    Locate(int a, int b, int p){
        r=a; c=b; this.p=p;
    }
}
