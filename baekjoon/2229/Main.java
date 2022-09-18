import java.io.*;
import java.util.*;

public class Main {			
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for(int j=i; j>0; j--){
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);
				dp[i] = Math.max(dp[i], max - min + dp[j-1]);
			}
		}
		
		System.out.println(dp[N]);
	}
}