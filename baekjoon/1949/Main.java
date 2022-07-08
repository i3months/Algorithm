import java.util.*;
import java.io.*;

public class Main{

	static int N;	
	static int[] arr;	

	static ArrayList<Integer>[] list;
	static int[][] dp;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;			

		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N+1];
		dp = new int[N+1][2];
		arr = new int[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}


		dfs(1, -1);

		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
		
	}

	static void dfs(int x, int prev){
		dp[x][1] = arr[x];
		for(int y : list[x]){
			if(y == prev){
				continue;
			}
			dfs(y,x);
			dp[x][0] = dp[x][0] + Math.max(dp[y][0], dp[y][1]);
			dp[x][1] = dp[x][1] + dp[y][0];
		}
	}
}