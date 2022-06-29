	import java.util.*;
	import java.io.*;
	import java.math.*;

	public class Main {							
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int dp[] = new int[1000001];

			dp[1] = 0;
			dp[2] = 1;

			for(int i=3; i<1000001; i++){
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
				int c = Integer.MAX_VALUE;

				if(i % 3 == 0){
					a = dp[i / 3] + 1;
				}
				if(i % 2 == 0){
					b = dp[i / 2] + 1;
				}

				c = dp[i-1] + 1;
				

				dp[i] = Math.min(a,b);
				dp[i] = Math.min(dp[i],c);
				
			}

			
			System.out.println(dp[Integer.parseInt(br.readLine())]);
		}
	}