import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int ans, N, K;
    static int[] arr;
    static final int INF = 987654321;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        for(int i=1; i<N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        int[] dp = new int[K+1];

        // bt(0,0); 백트래킹 불가능 시간초과임
        
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i=1; i<N+1; i++){
            for(int j=arr[i]; j<K+1; j+=arr[i]){
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
            // for(int k : dp){
            //     System.out.print(k+ " ");
            // }
            // System.out.println();
        }

        for(int i=1; i<N+1; i++){
            for(int j=arr[i]; j<K+1; j++){
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        System.out.println(dp[K] == INF ? -1 : dp[K]);
                
        
        

    }

    static void bt(int sum, int start){
        if(sum == K){
            ans++;
            return;
        }

        if(sum > K){
            return;
        }
        
        for(int i=start; i<N; i++){
            sum += arr[i];
            bt(sum, i);
            sum -= arr[i];
        }


    }
}