import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][N+1];

		for(int i=1;i <N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N+1][N+1];


		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
			}
		}

		// for(int i = 1; i<N+1; i++){
		// 	for(int j=1; j<N+1; j++){
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		int x1, y1, x2, y2;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			System.out.print((dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
		}

	}
}