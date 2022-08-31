import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];   
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<M+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        

        Arrays.fill(dp, 987654321);

        ArrayList<Integer> list = new ArrayList<>();        

        dp[0] = 0;

        for(int i=1; i<M+1; i++){
            for(int j=i + 1; j<M+1; j++){                
                int sum = arr[i] + arr[j];

                if(sum >= N + 1) continue;

                dp[sum] = 1;
                list.add(sum);
            }
        }
         
        for(int i=1; i<M+1; i++){
            dp[arr[i]] = 1;
            list.add(arr[i]);
        }

        for(int i=1; i<N+1; i++){
            for(int j=0; j<list.size(); j++){
                int val = i - list.get(j);
                if(val <= 0) continue;

                dp[i] = Math.min(dp[i], dp[val] + 1);
            }
        }

        System.out.println(dp[N] == 987654321 ? -1 : dp[N]);

    }
}