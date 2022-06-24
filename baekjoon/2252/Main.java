import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	

	static ArrayList<Integer>[] adj;
	static int[] indegree;
	static int N, M;
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			StringTokenizer st = new StringTokenizer(br.readLine());

			Deque<Integer> dq = new LinkedList<>();

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			adj = new ArrayList[N+1];
			indegree = new int[N+1];

			for(int i=1; i<N+1; i++){
				adj[i] = new ArrayList<>();
			}

			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				adj[x].add(y);
				indegree[y]++;
			}
			
			for(int i=1; i<N+1; i++){
				if(indegree[i] == 0){
					dq.add(i);					
				}				
			}

			ArrayList<Integer> list = new ArrayList<>();

			while(!dq.isEmpty()){				
				int x = dq.pollFirst();
				list.add(x);				

				for(int y : adj[x]){
					indegree[y]--;
					if(indegree[y] == 0){
						dq.add(y);
					}
				}
			}			
			
			for(int k : list){
				System.out.print(k + " ");
			}

			
	}
}