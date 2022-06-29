import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		
		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		
		for(int i=10; i<101; i++){
			dp[i] = dp[i-5] + dp[i-1];
		}

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<T; i++){
			sb.append(dp[Integer.parseInt(br.readLine())] + "\n");			
		}

		System.out.println(sb);



		
	}
}