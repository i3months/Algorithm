import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, K;	
	static ArrayList<Edge>[] list;	
    static PriorityQueue<Integer>[] resultPq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
        resultPq = new PriorityQueue[N+1];

		for(int i=0; i<N+1; i++){
			list[i] = new ArrayList<>();		
            resultPq[i] = new PriorityQueue<>(Collections.reverseOrder());	
		}
		
		for(int i=1; i<M+1; i++){
			st = new StringTokenizer(br.readLine());	

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Edge(to, weight));
		}

		
		dijkstra(1);

		for(int i=1; i<N+1; i++){
			if(resultPq[i].size() != K) System.out.println(-1);
            else System.out.println(resultPq[i].peek());
		}
		
	}

	static void dijkstra(int start){        

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	
        resultPq[start].add(0);

		while(!pq.isEmpty()){
			Info info = pq.poll();

			// if(dist[info.idx] != info.dist){
			// 	continue;
			// }

			for(Edge e : list[info.idx]){
				// if(dist[info.idx] + e.weight >= dist[e.to])	continue;				
                if(resultPq[e.to].size() < K){
                    resultPq[e.to].add(e.weight + info.dist);
                    pq.add(new Info(e.to, e.weight + info.dist));
                }else if(resultPq[e.to].peek() > e.weight + info.dist){
                    resultPq[e.to].poll();
                    resultPq[e.to].add(e.weight + info.dist);
                    pq.add(new Info(e.to, e.weight + info.dist));
                }else{
                    // pq.add(new Info(e.to, e.weight + info.dist));
                }
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