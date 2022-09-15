import java.io.*;
import java.util.*;

public class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		boolean[][] dp = new boolean[N + 1][10_000_00];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}		

		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int[] ansArr = new int[M + 1];
		st = new StringTokenizer(br.readLine());

		for(int i=1; i<M+1; i++){
			ansArr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1][arr[1]] = true;

		for(int i=2; i<N+1; i++){
			dp[i][arr[i]] = true;
			for(int j=1; j<10_000_00; j++){								
							
				if(dp[i-1][j]){
					dp[i][j] = true;

					int val = arr[i];

					if(Math.abs(val - j) >= 1){
						dp[i][Math.abs(val - j)] = true;
					}

					if(Math.abs(val + j) <= 10_000_00){
						dp[i][val + j] = true;
					}
				}

			}
		}

		for(int i=1; i<M+1; i++){
			if(dp[N][ansArr[i]]){
				sb.append("Y ");
			}else{
				sb.append("N ");
			}
		}

		System.out.println(sb);

		// for(int i=1; i<N+1; i++){
		// 	for(int j=1; j<13; j++){
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();

		// }
		
		

	}	
}