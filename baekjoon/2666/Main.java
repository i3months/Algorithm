import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[][][] dp;
    static int[] seq;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());                

        StringTokenizer st = new StringTokenizer(br.readLine());

        int open1 = Integer.parseInt(st.nextToken());
        int open2 = Integer.parseInt(st.nextToken());
                    
        M = Integer.parseInt(br.readLine());

        seq = new int[M+1];
        dp = new int[N+1][N+1][N+1];        

        for(int i=0; i<N+1; i++){
            for(int j=0; j<N+1; j++){
                for(int k=0; k<N+1; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        for(int i=1; i<M+1; i++){
            seq[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(1, open1, open2));        

        // for(int i=1; i<N+1; i++){
        //     for(int j=1; j<N+1; j++){
        //         for(int k=1; k<N+1; k++){
        //             System.out.print(dp[i][j][k] + " ");
        //         }System.out.println();
        //     }System.out.println();
        // }

        
        
                                        
    }

    static int solve(int idx, int open1, int open2){
        if(idx == M+1) return 0;

        // int res = dp[idx][open1][open2];
        // if(res != -1) return res;

        int target = seq[idx];
        return Math.min(Math.abs(open1-target) + solve(idx+1, target, open2), Math.abs(open2-target) + solve(idx+1, open1, target));

        // int target = seq[idx];
        // dp[idx][open1][open2] = Math.min(Math.abs(open1-target) + solve(idx+1, target, open2), Math.abs(open2-target) + solve(idx+1, open1, target));

        // return dp[idx][open1][open2];
        
    }

}