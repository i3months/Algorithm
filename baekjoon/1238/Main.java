	import java.io.*;
	import java.util.*;

	public class Main {

		static int N, M, X;
		static int[] dist, reverse_dist;	
		static ArrayList<Portal>[] list, reverse_list;
		static int INF = 1_000_000_000;
		

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine())	;

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			list = new ArrayList[N + 1];
			reverse_list = new ArrayList[N + 1];

			dist = new int[N + 1];
			reverse_dist = new int[N + 1];

			for(int i=1; i<N+1; i++){
				list[i] = new ArrayList<>();
				reverse_list[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				list[start].add(new Portal(end, cost));
				reverse_list[end].add(new Portal(start, cost));
			}

			dist = dijkstra(list, dist);
			reverse_dist = dijkstra(reverse_list, reverse_dist);

			int ans = 0;

			for(int i=1; i<N+1; i++){
				ans = Math.max(ans, dist[i] + reverse_dist[i]);
			}
			System.out.println(ans);
				
		}

		static int[] dijkstra(ArrayList<Portal>[] lis, int[] dis){
			boolean[] visit = new boolean[N + 1];

			PriorityQueue<Portal> pq = new PriorityQueue<>();
			pq.add(new Portal(X, 0));

			for(int i=1; i<N+1; i++){
				dis[i] = INF;
			}

			dis[X] = 0;

			while(!pq.isEmpty()){
				Portal tmp = pq.poll();
				int now = tmp.destination;

				if(visit[now]){
					continue;
				}

				visit[now] = true;

				for(Portal pt : lis[now]){
					if(dis[pt.destination] > dis[now] + pt.cost){
						dis[pt.destination] = dis[now] + pt.cost;
						pq.add(new Portal(pt.destination, dis[pt.destination]));
					}
				}
				
			}

			return dis;
			
		}
	}

	class Portal implements Comparable<Portal>{
		int destination, cost;

		Portal(int a, int b){
			destination = a;
			cost = b ;
		}

		public int compareTo(Portal o2){
			if(cost > o2.cost){
				return 1;
			}else{
				return -1;
			}		
		}

	}