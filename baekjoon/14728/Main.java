import java.io.*;
import java.util.*;

public class Main {			
	static int[][] dp;
	static int[][] arr;
	static int N, K;	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][K + 1];
		arr = new int[N + 1][2];

		for(int i=1 ;i<N+1; i++){
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<K+1; j++){
				if(arr[i][0] > j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]] + arr[i][1]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}	
}