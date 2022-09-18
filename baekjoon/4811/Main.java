import java.io.*;
import java.util.*;

public class Main {			
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		long[][] dp = new long[31][31];

		for(int i=0; i<31; i++){
			for(int j=0; j<31; j++){
				if(i > j) continue;

				if(i == 0){
					dp[j][i] = 1;
				}else{
					dp[j][i] = dp[j-1][i] + dp[j][i-1];
				} 

			}
		}

		

		while(true){
			int N = Integer.parseInt(br.readLine());

			if(N == 0){
				break;
			}

			System.out.println(dp[N][N]);
		}
		
	}
}