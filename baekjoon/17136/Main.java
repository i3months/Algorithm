import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[][] map = new int[10][10];
    static int ans = Integer.MAX_VALUE;
    static int[] remain = {0, 5, 5, 5, 5, 5};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0,0,0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);        

        
       

    }

    static void bt(int r, int c, int cnt){
        if(r == 10){
            ans = Math.min(ans, cnt);
            return;
        }
        
        if(c == 10){
            bt(r + 1, 0, cnt);
            return;
        }
        

        if(cnt >= ans){
            return;
        }

        if(map[r][c] == 1){
            for(int i = 5; i >= 1; i--){
                if(isCover(r, c, i) && remain[i] > 0){
                    cover(r, c, i);
                    remain[i]--;
                    bt(r, c + 1, cnt + 1);
                    undo(r, c, i);
                    remain[i]++;
                }
            }
        }else if (map[r][c] == 0 || map[r][c] == -1){
            bt(r, c + 1, cnt);
        }
        

    }

    static boolean isCover(int r, int c, int size){
        for(int i = r; i< r + size; i++){
            for(int j = c; j < c + size; j++){
                if(i >= 10 || j >= 10){
                    return false;
                }

                if(map[i][j] != 1){
                    return false;
                }
            }
        }

        return true;
    }

    static void cover(int r, int c, int size){
        for(int i=r; i< r + size; i++){
            for(int j=c; j<c + size; j++){
                map[i][j] = -1;
            }
        }
    }

    static void undo(int r, int c, int size){
        for(int i=r; i<r + size; i++){
            for(int j=c; j<c + size; j++){
                map[i][j] = 1;
            }
        }
    }
}