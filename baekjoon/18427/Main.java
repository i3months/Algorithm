import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[][] dp = new int[N + 1][H + 1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());		

			while(st.hasMoreTokens()){
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for(int i=0; i<list[1].size(); i++){
			dp[1][list[1].get(i)] = 1;
		}

		for(int i=0; i<N+1; i++){
			dp[i][0] = 1;
		}

		for(int i=2; i<N+1; i++){
			for(int j=1; j<H+1; j++){
				dp[i][j] = dp[i-1][j];
				dp[i][j] %= 10007;
				for(int k=0; k<list[i].size(); k++){
					if(j - list[i].get(k) <= -1){
						continue;
					}
					dp[i][j] += dp[i-1][j-list[i].get(k)];
					dp[i][j] %= 10007;
				}
			}
		}

		// System.out.println("debug");
		// for(int i = 1; i<H+1; i++){
		// 	System.out.print(dp[1][i] + " ");
		// }
		// System.out.println();
		// for(int i = 1; i<H+1; i++){
		// 	System.out.print(dp[2][i] + " ");
		// }
		// System.out.println();

		// for(int i = 1; i<H+1; i++){
		// 	System.out.print(dp[3][i] + " ");
		// }
		// System.out.println();

		// System.out.println("debug");
		
		int sum = 0;
		
		for(int i=1; i<N+1; i++){
			sum += dp[i][H];
		}
		// System.out.println(sum);

		System.out.println(dp[N][H]);
		


		

		
		
	}
}