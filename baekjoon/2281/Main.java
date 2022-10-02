import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int INF = 987654321;
    static int N, M;
    static int dp[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 0; i < N + 1 - 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, INF);

        System.out.println(solve(0));

        // for(int k : dp) System.out.print(k + " ");
        

    }

    static int solve(int idx){
        if(dp[idx] != INF) return dp[idx];

        int remain = M - arr[idx];

        for(int i=idx+1; i<N+1; i++){
            if(remain < 0) break;            
            if(i == N){
                dp[idx] = 0;
                break;
            }

            dp[idx] = Math.min(dp[idx], remain * remain + solve(i));
            remain -= arr[i] + 1;
            
        }

        return dp[idx];
        
    }

    // static int solve(int idx, int open1, int open2){
    // if(idx == M+1) return 0;

    // // int res = dp[idx][open1][open2];
    // // if(res != -1) return res;

    // int target = seq[idx];
    // return Math.min(Math.abs(open1-target) + solve(idx+1, target, open2),
    // Math.abs(open2-target) + solve(idx+1, open1, target));

    // // int target = seq[idx];
    // // dp[idx][open1][open2] = Math.min(Math.abs(open1-target) + solve(idx+1,
    // target, open2), Math.abs(open2-target) + solve(idx+1, open1, target));

    // // return dp[idx][open1][open2];

    // }

}