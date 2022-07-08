import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int start=0; start<T; start++){

			int K = Integer.parseInt(br.readLine());

			int[][] dp = new int[K+1][K+1];
			int[][] sum = new int[K+1][K+1]; // prefix sum
	
			int[] arr = new int[K+1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=1;i <K+1; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
	
			for(int i=1; i<K+1; i++){
				for(int j=i; j<K+1; j++){
					sum[i][j] = sum[i][j-1] + arr[j];
				}
			}
	
			for(int i=2; i<K+1; i++){
				for(int j=1; j<K+1-i+1; j++){
					int k = j - 1 + i;
					dp[j][k] = Integer.MAX_VALUE;
					for(int l = j; l<k; l++){
						dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l+1][k] + sum[j][k]);
					}
				}
			}

			// for(int a = 1; a<K+1; a++){
			// 	for(int b = 1; b<K+1; b++){
			// 		System.out.print(dp[a][b] + " ");
			// 	}
			// 	System.out.println();
			// }
	
			System.out.println(dp[1][K]);
		}
	}
}