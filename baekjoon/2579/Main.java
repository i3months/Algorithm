import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int N = Integer.parseInt(br.readLine());

			int[][] dp = new int[N+1][2];
			int[] arr = new int[N+1];

			for(int i=1; i<N+1; i++){
				arr[i] = Integer.parseInt(br.readLine());
			}

			dp[1][0] = 0;
			dp[1][1] = arr[1];
			
			if(N >= 2){
				dp[2][0] = arr[2];
				dp[2][1] = arr[1] + arr[2];
			}

			for(int i=3; i<N+1; i++){
				dp[i][0] = Math.max(dp[i-2][0] + arr[i], dp[i-2][1] + arr[i]);
				dp[i][1] = dp[i-1][0] + arr[i];
			}

			System.out.println(Math.max(dp[N][0], dp[N][1]));
			
			
	}
}