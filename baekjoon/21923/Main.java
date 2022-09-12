import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] map;	
	static int max = -987654321;
	static int[][][] dp;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1][2];

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<M+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[N][1][0] = map[N][1];
		
		for(int i=N; i>=1; i--){
			if(i != N){
				dp[i][1][0] = dp[i+1][1][0] + map[i][1];
			}
			for(int j=2; j<M+1; j++){
				if(i != N){
					dp[i][j][0] = Math.max(dp[i+1][j][0], dp[i][j-1][0]) + map[i][j];
				}else{
					dp[i][j][0] = dp[i][j-1][0] + map[i][j];
				}
			}
		}

		dp[N][M][1] = map[N][M];

		for(int i=N; i>=1; i--){
			if(i!=N){
				dp[i][M][1] = dp[i+1][M][1] + map[i][M];
			}
			for(int j=M-1; j>=1; j--){
				if(i!=N){
					dp[i][j][1] = Math.max(dp[i+1][j][1], dp[i][j+1][1]) + map[i][j];
				}else{
					dp[i][j][1] = dp[i][j+1][1] + map[i][j];
				}
			}
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				max = Math.max(max, dp[i][j][1] + dp[i][j][0]);
			}
		}
		
		System.out.println(max);
		
	}
}