import java.io.*;
import java.util.*;

public class Main {			
	static int INF = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}


		int ans = INF;

		for(int k=0; k<3; k++){

			for(int i=0; i<3; i++){
				if(i == k){
					dp[1][i] = arr[1][i];
				}else{
					dp[1][i] = INF;
				}
			}

			for(int i=2; i<N+1; i++){
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			
			for(int i=0; i<3; i++){
				if(i == k){
					continue;
				}

				ans = Math.min(ans, dp[N][i]);
			}

			System.out.println("debug");
			for(int i=1; i<N+1; i++){
				for(int j=0; j<3; j++){
					System.out.print(dp[i][j] > 90000 ? -1 + " " : dp[i][j] + " ");
				}System.out.println();
			}
			System.out.println("debug");
		}
		
		System.out.println(ans);
		

	}	
}