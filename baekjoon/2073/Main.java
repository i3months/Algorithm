import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[][] pipe = new int[P + 1][2];
		int[] dp = new int[D + 1];

		dp[0] = INF;

		for(int i=1; i<P+1; i++){
			st = new StringTokenizer(br.readLine());
			pipe[i][0] = Integer.parseInt(st.nextToken());
			pipe[i][1] = Integer.parseInt(st.nextToken());

			for(int j = D; j>= pipe[i][0]; j--){
				dp[j] = Math.max(dp[j], Math.min(pipe[i][1], dp[j - pipe[i][0]]));
			}
		}
			

		// for(int i=0; i<P; i++){
		// 	for(int j = D; j >= pipe[i][0]; j--){
		// 		dp[j] = Math.max(dp[j], Math.min(pipe[i][1], dp[j - pipe[i][0]]));
		// 	}
		// }

		System.out.println(dp[D]);
		// top down !
	}
}