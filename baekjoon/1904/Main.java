import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        if(N == 1){
            System.out.println(1);
            return;
        }

        if(N == 2){
            System.out.println(2);
            return;
        }

        if(N == 3){
            System.out.println(3);
            return;
        }

        if(N == 4){
            System.out.println(5);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5; 

        for(int i=5; i<N+1; i++){
            dp[i] = dp[i-2] + dp[i-1];
            dp[i] %= 15746;
        }

        System.out.println(dp[N]);

        

    }
}
