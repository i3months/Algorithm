import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[100_001];
		int[] dp = new int[100_001];

		prime[0] = prime[1] = true;

		for(int i=2; i<Math.sqrt(100_001); i++){			

			 if(prime[i] == true){
			 	continue;
			 }

			 dp[i] = 1;

			 for(int j= i*i; j<100_001; j = j+i){
			  	prime[j] = true;
			  }
		}

		for(int i= 2; i<B+1; i++){
			if(dp[i] == 0){
				int idx = 2;

				while(true){
					if(i % idx == 0){
						dp[i] = dp[i/idx] + 1;
						break;
					}
					idx++;
				}

			}
		}

		int ans = 0;

		for(int i=A; i<B+1; i++){
			if(prime[dp[i]] == false){
				ans++;
			}
		}

		//ans = ans == 0 ? 0 : ans + 1;

		System.out.println(ans);


	}
}