import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int TC = Integer.parseInt(br.readLine());

        while(TC-- >0){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=1; i<N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());

            int[] dp = new int[target + 1];
            dp[0] = 1;

            for(int i=1; i<N+1; i++){
                for(int j=arr[i]; j<target+1; j++){
                    dp[j] += dp[j - arr[i]];
                }
            }

            sb.append(dp[target] + "\n");
            
        }

        System.out.println(sb);

    }
}