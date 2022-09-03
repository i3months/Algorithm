import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 2][M + 2];
		dp = new int[N + 2][M + 2][3];

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<M+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<M+1; i++){
			dp[1][i][0] = map[1][i];
			dp[1][i][1] = map[1][i];
			dp[1][i][2] = map[1][i];
		}

		for(int i=2; i<N+1; i++){
			for(int j=1; j<M+1; j++){

				if(j - 1 >= 1){
					dp[i][j][0] = Math.min(dp[i-1][j-1][1] + map[i][j], dp[i-1][j-1][2] + map[i][j]);
				}else{
					dp[i][j][0] = Integer.MAX_VALUE/2;
				}

				dp[i][j][1] = Math.min(dp[i-1][j][0] + map[i][j], dp[i-1][j][2] + map[i][j]);

				if(j + 1 <= M){
					dp[i][j][2] = Math.min(dp[i-1][j+1][1] + map[i][j], dp[i-1][j+1][0] + map[i][j]);
				}else{
					dp[i][j][2] = Integer.MAX_VALUE/2;
				}

				// dp[i][j][0] = Math.min(dp[i-1][j-1][1] + map[i][j], dp[i-1][j-1][2] + map[i][j]);
				// dp[i][j][1] = Math.min(dp[i-1][j][0] + map[i][j], dp[i-1][j][2] + map[i][j]);
				// dp[i][j][2] = Math.min(dp[i-1][j+1][1] + map[i][j], dp[i-1][j+1][0] + map[i][j]);
			}
		}
		

		int min = Integer.MAX_VALUE;

		for(int i=1; i<M+1; i++){			
			min = Math.min(min, Math.min(dp[N][i][0], Math.min(dp[N][i][1], dp[N][i][2])));
		}

		System.out.println(min);

		// for(int i=0; i<3; i++){
		// 	System.out.println(dp[2][1][i]);
		// }
		
	}
}