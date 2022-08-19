import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[][] map;
    static int N, M, H;
    static int ans = -1;
    static boolean check = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int fin = Integer.parseInt(st.nextToken());

            map[start][fin] = 1;
            map[start][fin + 1] = 2;
        }

        for(int i=0; i<4; i++){
            ans = i;
            bt(1,1,0);
            if(check){
                break;
            }            
        }

        System.out.println(check ? ans : -1);

        

    }

    static void bt(int r, int c, int depth){
        if(check){
            return;
        }

        if(ans == depth){
            if(correspond()){
                check = true;
            }
            return;
        }

        for(int i = r; i<H + 1; i++){
            for(int j = c; j<N; j++){
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    bt(1,1, depth + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;

                    
                }
            }
        }
    
    }

    static boolean correspond(){
        for(int i=1; i<N + 1; i++){
            int nextR = 1;
            int nextC = i;

            while(nextR < H + 1){
                if(map[nextR][nextC] == 1){
                    nextC++;
                }else if(map[nextR][nextC] == 2){
                    nextC--;
                }

                nextR++;
            }

            if(nextC != i){
                return false;
            }
        }

        return true;
    }
}