import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];
		int[][] dp = new int[N + 1][M + 1];

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i - 1] + arr[i];
		}

		for(int i=0; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				dp[i][j] = Integer.MIN_VALUE / 2;
			}
		}

		dp[1][1] = arr[1];

		for(int i=2; i<N+1; i++){
			for(int j=1; j<M+1; j++){

				dp[i][j] = dp[i - 1][j];

				int min = j == 1 ? -1 : 0;

				for(int k = i-2; k >= min; k--){
					if(k == -1){
						dp[i][j] = Math.max(dp[i][j], sum[i]);
					}
					
					if(k >= 0){
						dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + sum[i] - sum[k+1]);
					}					

					
				}												
				
			}
		}

		System.out.println(dp[N][M]);


		// System.out.println("debug");

		// for(int i=0; i<N+1; i++){
		// 	for(int j=0; j<M+1; j++){
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		

	}
}