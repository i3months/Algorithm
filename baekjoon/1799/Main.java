import java.util.*;
import java.io.*;

public class Main{

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

        System.out.println(cnt1 + cnt2);
        
    }


    static void search1(int r, int c, int k){
        cnt1 = Math.max(k, cnt1);

        if(c >= N){
            r++;
            if(r % 2 == 0){
                c = 0;
            }else{
                c = 1;
            }
        }

        if(r >= N){
            return;
        }

        if(attackable1(r,c)){
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
                c = 1;
            }else{
                c = 0;
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
            int next_r = r + dr[i];
            int next_c = c + dc[i];

            for(int j=0; j < N; j++) {
                if(next_r >= 0 && next_c >= 0 && next_r < N && next_c < N) {
                    if(chk1[next_r][next_c]) return false;
                    
                    next_r += dr[i];
                    next_c += dc[i];
                }
            }
        }
        return true;
    }

    static boolean attackable2(int r, int c){
        if(map[r][c] == 0){
            return false;
        }

        for(int i=0; i<4; i++){
            int next_r = r + dr[i];
            int next_c = c + dc[i];

            for(int j=0; j < N; j++) {
                if(next_r >= 0 && next_c >= 0 && next_r < N && next_c < N) {
                    if(chk2[next_r][next_c]) return false;
                    
                    next_r += dr[i];
                    next_c += dc[i];
                }
            }
        }
        return true;
    }
}