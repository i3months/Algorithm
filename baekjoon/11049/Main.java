import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] matrix;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		N = Integer.parseInt(br.readLine());

		matrix = new int[N + 1][2];
		dp = new int[N + 1][N + 1];

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrix[i][0] = Integer.parseInt(st.nextToken());
			matrix[i][1] = Integer.parseInt(st.nextToken());
		}

		// for(int i=1; i<N; i++){
		// 	dp[i][i+1] = matrix[i][0] * matrix[i][1] * matrix[i+1][1];
		// 	dp[i+1][i] = dp[i][i+1];
		// }

		// for(int i=1; i<N+1; i++){
		// 	for(int j=i+1; j<N+1; j++){
		// 		for(int k=i+1; k<j-2; k++){

		// 			dp[i][j] = dp[i][k] + dp[k+1][j];
		// 			dp[i][j] += matrix[i][0] * matrix[k][1] * matrix[j][1];
		// 			System.out.println("zasdf");
		// 		}
		// 	}
		// }

		// System.out.println(dp[1][N]);
	

		System.out.println(solve(1,N));

			for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

	}

	static int solve(int s, int e){
		int result = 0;

		if(s == e){
			return 0;
		}

		if(dp[s][e] != 0){
			return dp[s][e];
		}

		if(e == s+1){
			result = matrix[s][0] * matrix[s][1] * matrix[e][1];
			dp[s][e] = result;
			return dp[s][e];
		}

		for(int i=s; i<e; i++){
			result = solve(s,i) + solve(i+1, e) + (matrix[s][0] * matrix[i][1] * matrix[e][1]);
			if(dp[s][e] == 0 || result < dp[s][e]){
				dp[s][e] = result;
			}
		}

		return dp[s][e];
	}
}