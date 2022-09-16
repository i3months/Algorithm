import java.io.*;
import java.util.*;

public class Main {			
	static int dp[], arr[];
	static ArrayList<Integer>[] list;
	static int max = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		list = new ArrayList[N + 1];
		
		st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}		

		dp = new int[1_000_001];

		for(int i=1; i<N+1; i++){						
			System.out.println(dfs2(i));			
		}

		// dfs2(1);

		// System.out.println("deug");
		// for(int i=1; i<N+1; i++) System.out.print(dp[i] + " ");
				
		
	}

	static int dfs2(int idx){
		if(dp[idx] != 0) return dp[idx];

		for(int i=0; i<list[idx].size(); i++){		

			if(arr[idx] < arr[list[idx].get(i)]) dp[idx] = Math.max(dp[idx], dfs2(list[idx].get(i)));
		}

		return ++dp[idx];
	}

	static int dfs(int idx, int depth){

		max = Math.max(max, depth);
		
		// if(dp[idx] != 0){
		// 	return dp[idx];
		// }

		for(int k : list[idx]){
			if(arr[k] > arr[idx]){
				dfs(k, depth + 1);
			}			
			// dp[idx] = Math.max(dp[idx], dfs(k));
		}
		
		dp[idx] = max;
		return dp[idx];



	}
}
