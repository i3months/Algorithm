import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] dp;
	String answer, candid;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
						
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 

		String a = br.readLine();
		String b = br.readLine();

		char[] candid = new char[N + 1];
		char[] answer = new char[M + 1];

		for(int i=1; i<N+1; i++){
			candid[i] = a.charAt(i - 1);
		}

		for(int i=1 ;i<M+1; i++){
			answer[i] = b.charAt(i-1);
		}

		dp = new int[N + 1][M + 1];

		for(int i=0; i<N+1; i++){
			dp[i][0] = i;
		}

		for(int i=0; i<M+1; i++){
			dp[0][i] = i;
		}

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				
				if(candid[i] == 'i'){
					if(answer[j] == 'i'){
						dp[i][j] = dp[i-1][j-1];
						continue;
					}

					if(answer[j] == 'j'){
						dp[i][j] = dp[i-1][j-1];
						continue;
					}

					if(answer[j] == 'l'){
						dp[i][j] = dp[i-1][j-1];
						continue;
					}
				}

				if(candid[i] == 'v'){
					if(answer[j] == 'v'){
						dp[i][j] = dp[i-1][j-1];
						continue;
					}

					if(answer[j] == 'w'){
						dp[i][j] = dp[i-1][j-1];
						continue;
					}
				}

				if(candid[i] == answer[j]){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
				}

				

			}
		}


		System.out.println(dp[N][M]);
		
		
	}
}