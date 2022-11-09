import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start, R;
	static int[] dist;
    static int[] item;
	static ArrayList<Edge>[] list;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		int TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
    
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
    
                // list[from].add(new Edge(to, weight));
                list[to].add(new Edge(from, weight));
            }
            
            dijkstra(R);

            int cnt = 0;
            int max = 0;

            for(int i=1; i<N+1; i++){
                if(dist[i] != INF){
                    cnt++;
                    max = Math.max(max, dist[i]);
                }
            }

            System.out.println(cnt + " " + max);


        }
                
		
	}

	static void dijkstra(int start){

		for(int i=1; i<N+1; i++){
			dist[i] = INF;
		}

        dist[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	

		while(!pq.isEmpty()){
			Info info = pq.poll();

			if(dist[info.idx] != info.dist){
				continue;
			}

			for(Edge e : list[info.idx]){
				if(dist[info.idx] + e.weight >= dist[e.to])	continue;				

				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));
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