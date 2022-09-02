import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    static int N;
    static int[] arr;
    static int[] dp;
    static long cnt;

    
    static long[][] dyp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
            
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        dyp = new long[N + 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // bt(1,0);
        // System.out.println(cnt);
        
        dyp[1][arr[1]] = 1;

        for(int i=2; i<N; i++){
            for(int j=0; j<21; j++){

                if(!(j + arr[i] >= 21)){                    
                    dyp[i][j + arr[i]] += dyp[i - 1][j];
                } 

                if(!(j - arr[i] <= -1)){
                    dyp[i][j - arr[i]] += dyp[i - 1][j];                   
                }
                            
                
            }
        }
        
        System.out.println(dyp[N - 1][arr[N]]);
        

    }
    
    static long solve(int sum, int idx){
        if(sum >= 21 || sum < 0){
            return 0;
        }

        if(idx == N - 2){
            if(sum == arr[N]){
                return 1;
            }else{
                return 0;
            }
        }

        if(dyp[sum][idx] != -1){
            return dyp[sum][idx];
        }
        dyp[sum][idx] = 0;

        return dyp[sum][idx] += solve(sum + arr[idx + 1], idx + 1) + solve(sum - arr[idx + 1], idx + 1);
    }

    static void bt(int depth, int num){
        if(num >= 21 || num < 0){
            return;    
        }

        if(depth == N){
            if(num == arr[N]){
                cnt++;
            }
            return;
        }

        bt(depth + 1, num + arr[depth]);

        bt(depth + 1, num - arr[depth]);


    }
}