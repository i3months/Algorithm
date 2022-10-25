import java.io.*;
import java.util.*;
 
public class Main {

    static int[] dl = {1,-1,0,0,0,0};
    static int[] dr = {0,0,-1,1,0,0};
    static int[] dc = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) break;

            

            int[][][] visit = new int[L][R][C];
            char[][][] map = new char[L][R][C];

            Locate start = null;
            Locate fin = null;

            for(int i=0; i<L; i++){
                if(i != 0) br.readLine();
                for(int j=0; j<R; j++){
                    String str = br.readLine();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = str.charAt(k);

                        if(map[i][j][k] == 'S'){
                            start = new Locate(i, j, k);
                        }

                        if(map[i][j][k] == 'E'){
                            fin = new Locate(i, j, k);
                        }
                        
                    }
                }
            }

            br.readLine();
                        
            Queue<Locate> q = new LinkedList<>();

            q.add(start);
            visit[start.l][start.r][start.c] = 1;

            while(!q.isEmpty()){
                Locate cur = q.poll();

                if(map[cur.l][cur.r][cur.c] == 'E'){
                    break;
                }

                for(int i=0; i<6; i++){
                    int nextL = cur.l + dl[i];
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if(nextL >= L || nextL <= -1 || nextR >= R || nextR <= -1 || nextC >= C || nextC <= -1) continue;
                    if(visit[nextL][nextR][nextC] != 0) continue;
                    if(map[nextL][nextR][nextC] == '#') continue;

                    q.add(new Locate(nextL, nextR, nextC));
                    visit[nextL][nextR][nextC] = visit[cur.l][cur.r][cur.c] + 1;                                        
                    
                }                
            }

            if(visit[fin.l][fin.r][fin.c] == 0){
                sb.append("Trapped!\n");
            }else{
                visit[fin.l][fin.r][fin.c] -= 1;
                sb.append("Escaped in " + visit[fin.l][fin.r][fin.c] + " minute(s).\n");
                // sb.append(visit[fin.l][fin.r][fin.c] + "\n");    
            }
            


            

        }
        
        System.out.println(sb);
    }   
}

class Locate{
    int l,r,c;
    Locate(int a, int b, int c){
        l=a;r=b;this.c=c;
    }
}