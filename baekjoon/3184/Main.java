import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int M;
    static char map[][];
        
    static boolean[][] visit;    
    static int cnt;

    static int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};

    static int wolf_cnt = 0;
    static int sheep_cnt = 0;

    static int wolf_ans = 0;
    static int sheep_ans = 0;
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j); 
                if(map[i][j] == 'o'){
                    sheep_ans++;
                }               
                if(map[i][j] == 'v'){
                    wolf_ans++;
                }
            }
        }

        //System.out.println(sheep_ans + " " + wolf_ans);

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
  
                if(!visit[i][j] && map[i][j] != '#'){  
                    wolf_cnt = 0;
                    sheep_cnt = 0;
                    dfs(i, j);
                    if(wolf_cnt >= sheep_cnt){       
                        //System.out.println(sheep_cnt + " " + wolf_cnt);                 
                        sheep_ans -= sheep_cnt;
                    }else{
                        wolf_ans -= wolf_cnt;
                    }


                }
            }
        }

        System.out.print(sheep_ans + " " + wolf_ans);

        

        
    }
    static void dfs(int r, int c){
        visit[r][c] = true;       

        if(map[r][c] == 'v'){
            wolf_cnt++;                    
        }

        if(map[r][c] == 'o'){                
            sheep_cnt++;                     
        } 
        
        for(int i=0; i<4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M){
                continue;
            }
            if(visit[nr][nc]){
                continue;
            }
            if(map[nr][nc] == '#'){
                continue;
            }          

            dfs(nr,nc);                        

        }
    }
}