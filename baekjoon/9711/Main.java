import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BigInteger[] dp = new BigInteger[10_001];
        int[] p = new int[N + 1];
        BigInteger[] q = new BigInteger[N + 1];
        

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine())        ;

            p[i] = Integer.parseInt(st.nextToken());
            q[i] = new BigInteger(st.nextToken());
        }

        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");

        for(int i = 3; i<10_001; i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<N+1; i++){
            sb.append("Case #" + i + ": " + dp[p[i]].remainder(q[i]) + "\n");            
        }

        System.out.println(sb);

        // for(int i=1; i<10; i++){
        //     System.out.println(dp[i].toString());
        // }

        
    }
}