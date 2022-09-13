import java.io.*;
import java.util.*;

public class Main {			
	static int[][] dp;
	static int[] arr;
	static int N;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		dp = new int[N+1][N+1];

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}	
				
		System.out.println(solve(1, N, 1));

	}

	static int solve(int left, int right, int day){
		if(left > right){
			return 0;
		}		
		
		if(dp[left][right] != 0){
			return dp[left][right];
		}

		dp[left][right] = Math.max(arr[left] * day + solve(left + 1, right, day + 1), arr[right] * day + solve(left, right - 1, day + 1));
		
		return dp[left][right];
	}
}