import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start, fin;
	static int[] dist;
	static ArrayList<Edge>[] list;
	static ArrayList<Integer>[] prev;
	static boolean[][] check;
    static StringBuilder sb = new StringBuilder();	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
		

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;
            
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            fin = Integer.parseInt(st.nextToken());
			
			check = new boolean[N + 1][N + 1];
            dist = new int[N + 1];
            list = new ArrayList[N + 1];
			prev = new ArrayList[N + 1];

			for(int i=0; i<N+1; i++){
				list[i] = new ArrayList<>();
				prev[i] = new ArrayList<>();
			}

            for(int i=1; i<M+1; i++){
				st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
    
                list[from].add(new Edge(to, weight));
            }

            dijkstra(start);
			removePath(start, fin);
            dijkstra(start);

			if(dist[fin] == INF){
				sb.append(-1 + "\n");
			}else{
				sb.append(dist[fin] + "\n");
			}

        }

		System.out.println(sb);
		
	}

    static void removePath(int start, int fin){
        if(start == fin) return;

		for(int cur : prev[fin]){
			if(!check[cur][fin]){
				check[cur][fin] = true;
				removePath(start, cur);
			}
		}
    }

	static void dijkstra(int start){

		for(int i=0; i<N+1; i++){
			dist[i] = INF;
		}

        dist[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx] < info.dist){
				continue;
			}
			

			for(Edge e : list[info.idx]){

				if(check[info.idx][e.to]) continue;

				if(dist[info.idx] + e.weight == dist[e.to]){
					prev[e.to].add(info.idx);
					// pq.add(new Info(e.to, dist[e.to]));
				}else if(dist[info.idx] + e.weight < dist[e.to]){
					dist[e.to] = dist[info.idx] + e.weight;
					prev[e.to].clear();
					prev[e.to].add(info.idx);	
					pq.add(new Info(e.to, dist[e.to]));
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