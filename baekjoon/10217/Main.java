import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, K;		
	static ArrayList<Edge>[] list;	
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		int TC = Integer.parseInt(br.readLine());

		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
	
			dist = new int[N+1][M+1];
			list = new ArrayList[N+1];					
	
			for(int i=1; i<N+1; i++){
				list[i] = new ArrayList<>();			
			}
			
			for(int i=1; i<K+1; i++){
				st = new StringTokenizer(br.readLine());	
	
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
	
				list[from].add(new Edge(to, weight, time));
			}
	
			
			dijkstra(1);
			int min = INF;
			for(int i=0; i<M + 1; i++) {
				min = Math.min(min, dist[N][i]);
			}

			System.out.println(min == INF ? "Poor KCM" : min);
					
		}
		
		
	}

	static void dijkstra(int start){

		for(int i=0; i<N+1; i++){
			Arrays.fill(dist[i], INF);
		}

        dist[1][0] = 0;		

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0, 0));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx][info.cost] < info.time){
				continue; // 최단거리가 아니면 바로 컷
			}

			for(Edge e : list[info.idx]){

				int nextTime = dist[info.idx][info.cost] + e.time;
				int nextCost = info.cost + e.weight;

				if(nextCost > M) continue;
				if(dist[e.to][nextCost] > nextTime) {
					dist[e.to][nextCost] = nextTime;
					pq.add(new Info(e.to, nextCost, nextTime));
				}				
			}
		}		
	}
}

class Edge{
	int to, weight, time;

	Edge(int a, int b, int c){
		to = a;
		weight = b;
		time = c;
	}    
}

class Info implements Comparable<Info>{
	int idx, cost, time;

	Info(){}    
	Info(int a, int b, int c){
		idx = a;
		cost = b;
		time = c;
	}

    @Override
	public int compareTo(Info o2){
		if(time > o2.time){
			return 1;
		}else if(time < o2.time){
			return -1;
		}else{
            return 0;
        }
	}
}