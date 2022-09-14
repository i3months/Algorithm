import java.io.*;
import java.util.*;

public class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		StringTokenizer st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[M + 1][C + 1];
		int[][] arr = new int[M + 1][C + 1];

		for(int i=1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());			
			for(int j=1; j<C+1; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<M+1; i++){
			for(int j=1; j<C+1; j++){
				dp[i][j] = dp[i-1][j];
				dp[i][j] = Math.max(dp[i][j], arr[i][j]);

				for(int k=1; k<j; k++){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + arr[i][j-k]);
				}
			}
		}

		// for(int i=1; i<M+1; i++){
		// 	for(int j=1; j<C+1; j++){
		// 		System.out.print(dp[i][j] + " ");
		// 	}System.out.println();
		// }

		System.out.println(dp[M][C]);
		
		
	}	
}