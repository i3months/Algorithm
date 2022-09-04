import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		while(TC-- >0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			long[][] dp = new long[N + 1][M + 1];

			for(int i=0; i<M+1; i++){
				dp[0][i] = 1;
			}

			for(int i=1; i<N+1; i++){
				for(int j=1; j<M+1; j++){
					dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
				}
			}

			System.out.println(dp[N][M]);

			// for(int i=1; i<M+1; i++){
			// 	System.out.print(dp[2][i] + " ");
			// }
		}
		
		
		
	}
}