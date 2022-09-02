import java.io.*;
import java.util.StringTokenizer;

public class Main5 {

	static int target,N;
	static int[][] coin;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		target = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());

		coin = new int[N][2];
        dp = new int[N][target+1];

		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i][0] = Integer.parseInt(st.nextToken());
			coin[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<target + 1; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(comb(0, 0));
	}
	
	static int comb(int money, int coinType) {
		if(money == target) {
			return 1;
		}

		if(coinType == N || money > target) {
			return 0;
		}

		if(dp[coinType][money] !=-1) {
			return dp[coinType][money];
		}
		
		int res = 0;

		for(int i=0; i<coin[coinType][1]+1; i++) {
			int cost = coin[coinType][0]*i;
			res += comb(money + cost , coinType + 1);
		}

		return dp[coinType][money] = res;
	}


}