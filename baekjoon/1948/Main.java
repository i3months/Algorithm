//DIJK
import java.util.*;
import java.io.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start, fin;
	static int[] dist;
	static ArrayList<Edge>[] list1;
    static ArrayList<Edge>[] list2;	
    static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list1 = new ArrayList[N+1];
        list2 = new ArrayList[N+1];
        dist = new int[N+1];

        for(int i=0; i<N+1; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list1[a].add(new Edge(b, c));
            list2[b].add(new Edge(a, c));            
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        fin = Integer.parseInt(st.nextToken());

        dijkstra(start);        

        System.out.println(dist[fin]);

        // for(int k : dist) {
        //     System.out.print(k + " ");
        // }
        // System.out.println();

        System.out.println(findPath());

		
	}

    static int findPath() {
        int ans = 0;
        visit = new boolean[N+1];
        visit[fin] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(fin);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(Edge k : list2[cur]) {
                if(dist[cur]-k.weight == dist[k.to]){
                    ans++;
                    if(!visit[k.to]){
                        visit[k.to]=true;
                        q.add(k.to);
                    }
                }
            }
        }

        return ans;
    }

	static void dijkstra(int start){

		// for(int i=1; i<N+1; i++){
		// 	dist[i] = -1;
		// }

        dist[start] = 0;

		PriorityQueue<Info> pq = new PriorityQueue<>();

		pq.add(new Info(start, 0));	

		while(!pq.isEmpty()){            
			Info info = pq.poll();

			if(dist[info.idx] > info.dist){
				continue;
			}

			for(Edge e : list1[info.idx]){
                // System.out.println("asdf");
				if(dist[info.idx] + e.weight > dist[e.to]){

                // System.out.println("asdf");
				dist[e.to] = dist[info.idx] + e.weight;
				pq.add(new Info(e.to, dist[e.to]));}
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
    public int compareTo(Info o2) {
        return o2.dist - dist;
    }

    // @Override
	// public int compareTo(Info o2){
	// 	if(dist < o2.dist){
	// 		return 1;
	// 	}else if(dist > o2.dist){
	// 		return -1;
	// 	}else{
    //         return 0;
    //     }
	// }
}