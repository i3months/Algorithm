import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start, fin;
	static int[] dist;
	static ArrayList<Edge>[] list;	
    static int[] prev;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());		

        prev = new int[N + 1];
		dist = new int[N+1];
		list = new ArrayList[N+1];

		for(int i=1; i<N+1; i++){
			list[i] = new ArrayList<>();		            
		}
		
		for(int i=1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());	

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));
		}

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        fin = Integer.parseInt(st.nextToken());
		
		dijkstra(start);        

		System.out.println(dist[fin]);

        ArrayList<Integer> routes = new ArrayList<>();

        int cur = fin;

        while(cur != 0) {
            routes.add(cur);
            cur = prev[cur];
        }

        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
        
		
	}

	static void dijkstra(int start){

		for(int i=1; i<N+1; i++){
			dist[i] = INF;
		}

        dist[start] = 0;
        prev[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx] != info.dist){
				continue;
			}

			for(Edge e : list[info.idx]){
				if(dist[info.idx] + e.weight >= dist[e.to]){
					continue;
				}

				dist[e.to] = dist[info.idx] + e.weight;                
				pq.add(new Info(e.to, dist[e.to]));
                prev[e.to] = info.idx;
			}
		}
	}
}

class Edge{
	int to, weight;

	Edge(int a, int b){
		to = a;
		weight = b;
	}
}

class Info implements Comparable<Info>{
	int idx, dist;

	Info(){}    
	Info(int a, int b){
		idx = a;
		dist = b;
	}

    @Override
	public int compareTo(Info o2){
		if(dist > o2.dist){
			return 1;
		}else if(dist < o2.dist){
			return -1;
		}else{
            return 0;
        }
	}
}