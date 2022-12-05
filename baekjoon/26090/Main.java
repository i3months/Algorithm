import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;

    static int N;
    static int[] arr;
    static boolean[] select;
    static boolean prime[];

    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        select = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makePrime();
        
        int[] dp = new int[N+1];

        for(int i=1; i<N+1; i++) {
            dp[i] = dp[i-1] + arr[i];
        }
        

        for(int i=1; i<N+1; i++) {
            for(int j=0; j<i; j++) {
                int cnt = i-j;
                int tempSum = dp[i]-dp[j];
                
                if(!prime[cnt] && !prime[tempSum]) ans ++;
            }
        }

        System.out.println(ans);       

    }

    static void makePrime() {
        prime = new boolean[1_000_001];

        prime[0] = prime[1] = true;

        for(int i=2; i<= Math.sqrt(1_000_000); i++) {
            if(prime[i]) continue;

            for(int j=i*i; j<1_000_000; j=j+i) {
                prime[j] = true;
            }
        }
    }

}