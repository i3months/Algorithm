import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int N = Integer.parseInt(br.readLine());

			int[][] dp = new int[N+1][10];

			for(int i=0; i<10; i++){
				dp[1][i] = 1;
			}

			for(int i=2; i<N+1; i++){
				for(int j=0; j<10; j++){
					for(int k=0; k<j+1; k++){
						dp[i][j] = dp[i][j] + dp[i - 1][k];
						dp[i][j] = dp[i][j] % 10007;
					}
				}
			}

			int ans = 0;
			for(int i=0; i<10; i++){
				ans = (ans + dp[N][i]) % 10007;				
			}

			System.out.println(ans);
			
	}
}