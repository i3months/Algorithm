import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());		

		int[][] dp = new int[N+1][3];
		int[] arr = new int[3];

		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;		

		// for(int i=0; i<3; i++){
		// 	arr[i] =  Integer.parseInt(st.nextToken());
		// }

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){				
				arr[j] =  Integer.parseInt(st.nextToken());
			}

			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])  + arr[0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])  + arr[1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[2];
			
		}
		

		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

	

	}
}