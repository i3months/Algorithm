import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	
		static int[] arr;
		static int[][] dp;
		static int[][] sum;
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int T = Integer.parseInt(br.readLine());				

			for(int i=0; i<T; i++){				
				int N = Integer.parseInt(br.readLine());

				arr = new int[N+1];
				dp = new int[N+1][N+1];
				sum = new int[N+1][N+1];

				StringTokenizer st = new StringTokenizer(br.readLine());

				for(int j=1; j<N+1; j++){
					arr[j] = Integer.parseInt(st.nextToken());
				}

				for(int j=1; j<N+1; j++){
					for(int k=j; k<N+1; k++){
						sum[j][k] = sum[j][k-1] + arr[j];
					}
				}

				for(int j=1; j<N+1; j++){
					for(int k=1; k<N+1; k++){
						System.out.print(sum[j][k] + " ");
					}
				}
				

				for(int len = 2; len< N+1; len++){
					for(int k=1; k<N+1 - len; k++){
						int l = k + len - 1;
						dp[k][l] = Integer.MAX_VALUE;

						for(int m=k; m<l; m++){
							dp[k][l] = Math.min(dp[k][l], dp[k][m] + dp[m+1][l] + sum[k][l]);
						}
					}
				}

				System.out.println(dp[1][N]);
				
			}			
					
			
	}
}