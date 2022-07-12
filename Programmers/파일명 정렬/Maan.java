import java.util.*;
import java.io.*;

public class Maan{

    static int[][] map;
    static int N;
    
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {-1, 1, -1, 1};

    static boolean chk1[][];
    static boolean chk2[][];

    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        
        chk1 = new boolean[N][N];
        chk2 = new boolean[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search1(0,0,0);
        search2(0,1,0);             


        
    }


    static void search1(int r, int c, int k){
        cnt1 = Math.max(k, cnt1);

        if(c >= N){
            r++;
            if(r % 2 == 0){
                c = 1;
            }else{
                c = 0;
            }
        }

        if(c >= N){
            return;
        }

        if(attakable1(r,c)){
            chk1[r][c] = true;
            search1(r, c+2, k+1);
            chk1[r][c] = false;
        }

        search1(r,c+2, k);
    }

    static void search2(int r, int c, int k){
        cnt2 = Math.max(cnt2, k);

        if(c >= N){
            r++;
            if(r % 2 == 0){
                c = 2;
            }else{
                c = 1;
            }
        }

        if(r >= N){
            return;
        }

        if(attackable2(r,c)){
            chk2[r][c] = true;
            search2(r,c+2, k+1);
            chk2[r][c] = false;
        }

        search2(r,c+2,k);
    }

    static boolean attackable1(int r, int c){
        if(map[r][c] == 0){
            return false;
        }

        for(int i=0; i<4; i++){
            int dr = r + dr[i];
            int dc = c + dc[i];

            for(int j=0; j < N; j++) {
                if(dr > 0 && dc > 0 && dr < N && dc < N) {
                    if(chk1[dr][dc]) return false;
                    
                    dr += dy[i];
                    dc += dx[i];
                }
            }
        }
    }

    static boolean attackable2(int r, int c){
        if(map[r][c] == 0){
            return false;
        }

        for(int i=0; i<4; i++){
            int dr = r + dr[i];
            int dc = c + dc[i];

            for(int j=0; j < N; j++) {
                if(dr > 0 && dc > 0 && dr < N && dc < N) {
                    if(chk2[dr][dc]) return false;
                    
                    dr += dy[i];
                    dc += dx[i];
                }
            }
        }
    }
}