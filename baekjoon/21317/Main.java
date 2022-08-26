import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int ans, N, K;
    static Stone[] arr;
    static final int INF = 987654321;
    static int dp[];
    static boolean bigbig;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        ans = Integer.MAX_VALUE;

        N = Integer.parseInt(br.readLine());
        
        arr = new Stone[N + 1];
        dp = new int[N+1];

        for(int i=1; i<N; i++){
            arr[i] = new Stone();

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i].small = Integer.parseInt(st.nextToken());
            arr[i].big = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());                

        bt(1);

        System.out.println(ans);
        
    }
    static void bt(int idx){
        if(idx == N){
            ans = Math.min(ans, dp[N]);
            return;
        }

        for(int i=0; i<2; i++){

            if(!bigbig){
                if(idx + 3 <= N){
                    idx += 3;
                    bigbig = true;
                    dp[idx] = dp[idx - 3] + K;
                    bt(idx);
                    dp[idx] = dp[idx - 3] - K;
                    bigbig = false;
                    idx -= 3;
                }                
            }

            if(i == 0){
                if(idx + 1 <= N){
                    idx += 1;
                    dp[idx] = dp[idx - 1] + arr[idx - 1].small;
                    bt(idx);
                    dp[idx] = dp[idx - 1] - arr[idx - 1].small;
                    idx -= 1;
                }
            }

            if(i == 1){
                if(idx + 2 <= N){
                    idx += 2;
                    dp[idx] = dp[idx - 2] + arr[idx - 2].big;
                    bt(idx);
                    dp[idx] = dp[idx - 2] - arr[idx - 2].big;
                    idx -= 2;
                }
            }

            
        }


    }
}

class Stone{
    int small, big;    
}