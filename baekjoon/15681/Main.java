import java.util.*;
import java.io.*;

public class Main{

	static int N;
	static int R;
	static int Q;

	static ArrayList<Integer>[] list;
	static int[] dp;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		dp = new int[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=1; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list[x].add(y);
			list[y].add(x);
		}

		dfs(R, -1);

		for(int i=1; i<Q+1; i++){
			int q = Integer.parseInt(br.readLine());
			System.out.println(dp[q]);
		}
		
		
	}

	static void dfs(int x, int prev){
		dp[x] = 1;
		for(int y : list[x]){
			if(y == prev){
				continue;
			}
			dfs(y,x);
			dp[x] = dp[x] + dp[y];
		}
	}
}