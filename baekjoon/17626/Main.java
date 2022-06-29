	import java.util.*;
	import java.io.*;
	import java.math.*;

	public class Main {							
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int N = Integer.parseInt(br.readLine());

			int[] dp = new int[50001];

			dp[1] = 1;

			int min = Integer.MAX_VALUE;

			for(int i=2; i<50001; i++){
					min = Integer.MAX_VALUE;
				for(int j=1; j*j <= i; j++){
					min = Math.min(min, dp[i - j*j]);
				}
				dp[i] = min + 1;
			}

			System.out.println(dp[N]);
			
		}
	}