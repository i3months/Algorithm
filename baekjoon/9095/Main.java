import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		
		int[] dp = new int[12];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;

		for(int i=5; i<12; i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}


		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++){
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb);
	}
}