import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int INF = 987654321;
	static int N;
	static int[] arr;
	static int[] dp;
	static boolean[] visit;		
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        		
		N = Integer.parseInt(br.readLine());	
		arr = new int[N + 1];
		dp = new int[N + 1];
		visit = new boolean[N + 1];			

		int res = 0;
		Arrays.fill(dp, -1);

		// for(int k : dp){
		// 	System.out.println(k);
		// }
		for(int i=1; i<N+1; i++){
			res = Math.max(res, dfs(i));
		}

		System.out.println(res);	
		
	}

	static int dfs(int idx){			
		
		if(dp[idx] != -1) return dp[idx];

		visit[idx] = true;

		int next = idx;
		String tmp = String.valueOf(idx);

		for(int i=0; i<tmp.length(); i++){
			next += (tmp.charAt(i) - '0');	
		}

		if(next > N) next = next - N;

		arr[idx] = next;

		if(visit[next]){
			if(dp[next] != -1){
				// dp[idx] = dp[next] + 1;
				// return dp[idx];				
				return dp[idx] = dp[next] + 1;
			}

			dp[idx] = 1;
			// System.out.println(dp[idx]);

			int count = next;
			while (count != idx) {
				dp[idx]++;
				count = arr[count];
			}

			count = next;
			while (count != idx) {
				dp[count] = dp[idx];
				count = arr[count];
			}					


			return dp[idx];
		
		}else{			
			dfs(next);

			if(dp[idx] == -1){
				// dp[idx] = dfs(next) + 1;	
				// return dp[idx];		
				return dp[idx] = dfs(next) + 1;
			}

			return dp[idx];
		}		
	

	}
}