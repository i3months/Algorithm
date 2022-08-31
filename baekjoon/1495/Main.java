import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    static int[] arr;
    static boolean[][] dp;

    static int N, S, M;

    static int max = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new boolean[N + 1][1001];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(S + arr[1] <= M){
            dp[1][S + arr[1]] = true;
        }

        if(S - arr[1] >= 0){
            dp[1][S - arr[1]] = true;
        }

        for(int i=2; i<N + 1; i++){
            for(int j=0; j<M+1; j++){
                if(!dp[i - 1][j]) continue;

                if(j + arr[i] <= M) dp[i][j + arr[i]] = true;
                if(j - arr[i] >= 0) dp[i][j - arr[i]] = true;
            }
        }

        for(int i=0; i<M+1; i++){
            if(!dp[N][i]) continue;
            max = i;
        }

        System.out.println(max);
    

            

    }
    // static void bt(int depth){
    //     if(depth == N + 1){            
    //         max = Math.max(max, dp[N]);
    //         return;
    //     }

    //     int before = dp[depth - 1];

    //     if(before + arr[depth] <= M){
    //         dp[depth] = before + arr[depth];
    //         bt(depth + 1);
    //     }

    //     if(before - arr[depth] >= 0){
    //         dp[depth] = before - arr[depth];
    //         bt(depth + 1);
    //     }

    //     if(before + arr[depth] > M || before - arr[depth] < 0){
    //         return;
    //     }



    // }
}