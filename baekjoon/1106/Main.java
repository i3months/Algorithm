import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));            

        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N + 1];
        int[] effect = new int[N + 1];

        for(int i=1; i<N+1;i ++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            effect[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[10_000_000];

        for(int i=1; i<N+1; i++){
            for(int j=cost[i]; j<10_000_000; j++){
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + effect[i]);
            }
        }

      
        for(int i=1; i<10_000_000; i++){
            if(dp[i] >= C){
                System.out.println(i);
                break;
            }
        }


    }
}