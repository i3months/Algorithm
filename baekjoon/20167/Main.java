import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {    

    static int[] arr;
    static long[] sumArr;
    static long[] dp;
    static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dp = new long[N+1];

        st = new StringTokenizer(br.readLine());        
        for(int i=1; i<N+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        sumArr = new long[N+1];
        for(int i=1; i<N+1; i++) sumArr[i] = sumArr[i-1] + arr[i];

     
        System.out.println(solve(1));
        

    }

    static long solve(int num) {
        if(num >= N+1) return 0;
        if(dp[num] != 0) return dp[num];
        
        int L = num-1;
        int R = N+1;        

        while(L + 1 < R) {

            int mid = (L + R) / 2;
            
            long val = sumArr[mid] - sumArr[num-1];

            if(val >= K) {                
                R = mid;
            } else {
                L = mid;
            }
        }

        long m = solve(num+1);

        if(R != N+1) {
            long left = (sumArr[R] - sumArr[num-1]) - K;
            m = Math.max(m, left + solve(R + 1));            
        }
                        
        dp[num] = m;
        

        return dp[num];
    }

}