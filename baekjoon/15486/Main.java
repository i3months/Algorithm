import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

        int N = Integer.parseInt(br.readLine());
        
        int[] cost = new int[N+2];
        int[] gain = new int[N+2];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            cost[i] = Integer.parseInt(st.nextToken());
            gain[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        int max = -1;

        for(int i=1; i<N+2; i++){
            if(max < dp[i]){
                max = dp[i];
            }

            int next = i + cost[i];
            
            if(next < N + 2){
                dp[next] = Math.max(dp[next], max + gain[i]);
            }
        }

        for(int k : dp){
            System.out.print(k + " ");
        }

        System.out.println(max);

        

    }
}