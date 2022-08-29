import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    static long[][] arr = new long[1_000_001][2]; 
    static long[] dp = new long[1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
        
        int N = Integer.parseInt(br.readLine());
            
        System.out.println(djp(N));

    }

    static long djp(int idx){
        if(idx == 0) return 1;
        if(idx == 1) return 0;
        if(idx == 2) return 3;    
        if(dp[idx] != 0) return dp[idx];
        long res = 3 * djp(idx - 2);
        for(int i=3; i<idx+1; i++){
            if(i % 2 == 0){
                res += 2 * djp(idx - i);
            }
        }
        return dp[idx] = res;
    }

    static long dyp(int idx){
        arr[0][0] = 0;
        arr[1][0] = 2;
        arr[2][0] = 7;
        arr[2][1] = 1;

        for(int i=3; i<idx + 1; i++){
            arr[i][1] = (arr[i - 1][1] + arr[i - 3][0]) % 1000000007;            
        }
        return 1;
    }
}