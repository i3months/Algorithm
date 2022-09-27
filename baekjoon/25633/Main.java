import java.util.*;
import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());        

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        for(int i=1; i<N+1; i++){
            int weight = arr[i];
            int cnt = 1;
            
            for(int j=i+1; j<N+1; j++){
                if(weight >= arr[j]){
                    weight += arr[j];
                    cnt++;
                    dp[j] = Math.max(dp[j], cnt);
                }
            }
        }

        int max = -1;

        for(int i=1; i<N+1; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        
    }
}