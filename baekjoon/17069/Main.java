import java.io.*;
import java.util.*;

public class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;

		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){

				if(i == 1 && j == 2){
					continue;
				}

				// if(map[i][j] == 1 || map[i-1][j-1] == 1 || map[i-1][j] == 1 || map[i][j-1] == 1){
				// 	continue;
				// }
				
				
				// dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				// dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				// dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];

				if(map[i][j] == 1){
					continue;
				}
				
				if(map[i][j-1] == 0){
					dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];	
				}				

				if(map[i-1][j] == 0){
					dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];	
				}				

				if(map[i-1][j-1] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0){
					dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];			
				}
			

			}
		}
		
		// for(int i=1; i<N+1; i++){
		// 	for(int j=1; j<N+1; j++){
		// 		System.out.print(dp[i][j][0] + dp[i][j][1] + dp[i][j][2] + " ");
		// 	}System.out.println();
		// }
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);

	}	
}