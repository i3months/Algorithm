import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static int V;

	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];

		for(int i=1; i<N+1; i++){
			adj[i] = new ArrayList<>();
		}

		for(int i = 1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			adj[temp1].add(temp2);
			adj[temp2].add(temp1);
		}

		for(int i=1 ;i<N+1; i++){
			Collections.sort(adj[i]);
		}

		////////////// end of input

		visit = new boolean[N+1];

		dfs(V);

		sb.append("\n");

		visit = new boolean[N+1];

		bfs(V);

		System.out.println(sb);
		
		
	}

	static void dfs(int x){
		visit[x] = true;
		sb.append(x).append(" ");
/*
		for(int y = 0; y < adj[x].size(); y++){
			int tmp = adj[x].get(y);			
			if(visit[tmp]){
				continue;
			}
			dfs(tmp);
		}
*/
		for(int y : adj[x]){
				
			if(visit[y]){
				continue;
			}
			dfs(y);
		}
		
	}

	static void bfs(int x){
		Queue<Integer> q = new LinkedList<>();

		q.add(x);
		visit[x] = true;

		while(!q.isEmpty()){
			int tmp = q.poll();

			sb.append(tmp).append(" ");

			for(int y : adj[tmp]){
				if(visit[y]){
					continue;
				}

				q.add(y);
				visit[y] = true;
			}

			
		}
	}
}