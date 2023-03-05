import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();      
    static final int INF = 987654321;  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1;i ++ ) {
            int idx = Integer.parseInt(st.nextToken());
            dp[idx] = dp[idx-1] + 1;
        }

        int val = 0;

        for(int i=1; i<n+1; i++) val = Math.max(val, dp[i]);

        System.out.println(n - val);

    }
}
