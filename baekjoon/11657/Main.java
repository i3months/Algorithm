import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<Edge> list;
	static final int INF = 987654321;
	static long[] dist;
	static long[] originDist;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		dist = new long[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Edge(from, to, cost));
		}
		        
		bellmanFord(1);

	}

	static void bellmanFord2(int start){

		originDist = new long[N + 1];

		for(int i=0; i<N+1; i++) originDist[i] = dist[i];
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				Edge edge = list.get(j);				

				if(dist[edge.from] == INF) continue;
				if(dist[edge.to] <= dist[edge.from] + edge.cost) continue; 

				dist[edge.to] = dist[edge.from] + edge.cost;								
			}
		}

		
		
	}
	
	static void bellmanFord(int start) {

		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < M; j++) {
				Edge edge = list.get(j);				

				if(dist[edge.from] == INF) continue;
				if(dist[edge.to] <= dist[edge.from] + edge.cost) continue; 

				dist[edge.to] = dist[edge.from] + edge.cost;								
			}
		}
		
		bellmanFord2(start);

		// 음수 간선 체크
		for (int i = 0; i < N + 1; i++) {
			if(dist[i] < originDist[i]){
				System.out.println(-1);
				System.exit(0);
			}		
		}
		// for(int i=0; i<N+1; i++){
		// 	System.out.print("debug : ");
		// 	System.out.println(dist[i] + " " + originDist[i]);
		// }

		for(int i=2; i<N+1; i++){
			if(originDist[i] == INF) System.out.println(-1);
			else System.out.println(originDist[i]);
		}
						
		return;
	}
}

class Edge {
	int from;
	int to;
	int cost;

	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}