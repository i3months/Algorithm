import java.io.*;
import java.util.*;

public class Main {			
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<N+1; i++){
			dp[i][i] = 1;
		}

		for(int i=1; i<=N-1; i++){
			if(arr[i] == arr[i+1]){
				dp[i][i+1] = 1;
			}
		}

		for(int i=2; i<N; i++){
			for(int j=1; j<=N-i; j++){
				if(arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1){
					dp[j][j+i] = 1;
				}
			}
		}	

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());

			sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]+"\n");
		}

		System.out.println(sb);
		
		
	}
}