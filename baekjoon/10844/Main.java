import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long mod = 1_000_000_000;

        long[][] dp = new long[N+1][10];

        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        long ans = 0;

        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % mod;
                }else

                if(j == 9){
                    dp[i][9] = dp[i-1][8] % mod;
                }

                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }


        for(int i=0; i<10; i++){
            ans+= dp[N][i];
            ans %= mod;
        }

        System.out.println(ans);
        

        
        
        

    }
}    
