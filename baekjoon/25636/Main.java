import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static long INF = Long.MAX_VALUE;

	static int N, M, start, fin;
	static long[] dist;
	static int[] water;
	// static long[] water2;
	static ArrayList<Edge>[] list;	
	static long ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								

		N = Integer.parseInt(br.readLine());					

		dist = new long[N+1];
		list = new ArrayList[N+1];
		water = new int[N+1];
		// water2 = new long[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();			
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1;i ++){
			water[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		
		for(int i=1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());	

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));
			list[to].add(new Edge(from, weight));
		}

		st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		fin = Integer.parseInt(st.nextToken());

		
		
		dijkstra(start);

		if(dist[fin] == INF) {
			System.out.println(-1);
			return;
		}

		System.out.println(dist[fin] + " " + ans);

		
		
	}

	static void dijkstra(int start){

		for(int i=1; i<N+1; i++){
			dist[i] = INF;
		}

        dist[start] = 0;
		// water2[start] = water[start];

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0, water[start]));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx] < info.dist){
				continue; // 최단거리가 아니면 바로 컷
			}

			for(Edge e : list[info.idx]){				
				if(dist[info.idx] + e.weight > dist[e.to])	continue;				

				// if(dist[info.idx] + e.weight == dist[e.to]) {
					// if(water2[e.to] < water2[info.idx] + water[e.to]) water2[e.to] = water2[info.idx] + water[e.to];	
					// pq.add(new Info(e.to, dist[e.to]));
					// continue;
				// }
				
				// if(water2[e.to] < water2[info.idx] + water[e.to]) water2[e.to] = water2[info.idx] + water[e.to];	
				// water2[e.to] = water2[info.idx] + water[e.to];
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to], info.waters + water[e.to]));
				if(e.to == fin) ans = Math.max(ans, info.waters + water[e.to]);
				
			}
		}
	}
}

class Edge{
	int to;
	int weight;

	Edge(int a, int b){
		to = a;
		weight = b;
	}

    @Override
    public boolean equals(Object o2){
        Edge o3 = (Edge)o2;

        if(to == o3.to && weight == o3.weight){
            return true;
        }
        return false;
    }
}

class Info implements Comparable<Info>{
	int idx;
	long dist;
	long waters;

	Info(){}    
	Info(int a, long b, long c){
		idx = a;
		dist = b;
		waters = c;
	}

    @Override
	public int compareTo(Info o2){
		if(dist > o2.dist){
			return 1;
		}else if(dist < o2.dist){
			return -1;
		}else{
            if(waters > o2.waters) {
				return 1;
			}else{
				return -1;
			}
        }
	}
}