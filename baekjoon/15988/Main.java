import java.util.*;
import java.io.*;
import java.math.*;

public class Main{	

	static long dp[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new long[1_000_001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;

		for(int i=5; i<1_000_001; i++){
			dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
		}

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			int T = Integer.parseInt(br.readLine());
			System.out.println(dp[T]);
		}
		
	}
}