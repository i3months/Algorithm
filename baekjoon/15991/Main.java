import java.util.*;
import java.io.*;
import java.math.*;

public class Main{	

	static long dp[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new long[1_000_001];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;

		for(int i=7; i<1_000_001; i++){
			dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1_000_000_009;
		}

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			int T = Integer.parseInt(br.readLine());
			System.out.println(dp[T]);
		}
		
	}
}