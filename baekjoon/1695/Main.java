import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
						
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<N+1; i++){
			Arrays.fill(dp[i], -1);
		}

		for(int i=1; i<N; i++){
			for(int j= i+1; j<N+1; j++){
				solve(i,j);
			}
		}
		
		System.out.println(dp[1][N]);

	}
	
	static int solve(int start, int end){
		if(dp[start][end] != -1) return dp[start][end];

		if(start >= end){
			dp[start][end] = 0;
			return dp[start][end];
		}

		if(arr[start] == arr[end]){
			dp[start][end] = solve(start + 1, end - 1);
		}else{
			dp[start][end] = Math.min(solve(start, end - 1), solve(start + 1, end)) + 1;
		}

		return dp[start][end];
	}
}