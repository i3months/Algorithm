import java.util.*;
import java.io.*;

 public class Main {

    static int ans = 0;
    static int N = 0;
    static int[] col;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        col = new int[N+1];

        backtracking(1);

        System.out.println(ans);
    }

    static void backtracking(int row){
        if(row == N+1){
            ans++;
        }else{
            for(int c = 1; c <= N; c++){
                boolean chk = true;
                for(int i=1; i<=row-1; i++){

                    if(attackable(row, c, i, col[i])){
                        chk = false;
                        break;
                    }
                }


                if(chk){
                    col[row] = c;
                    backtracking(row+1);
                    col[row] = 0;
                }

            }
        }
    }


    static boolean attackable(int r1, int c1, int r2, int c2){
        if(c1 == c2){
            return true;
        }
        
        if(Math.abs(c1 - c2) == Math.abs(r1 - r2)){
            return true;
        }

        return false;
    }


}