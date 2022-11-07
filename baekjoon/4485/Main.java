import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start;
	static int[] dist;
	static ArrayList<Edge>[] list;	

    static int[][] map;

    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

        int idx = 1;

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[N][N];

            for(int i=0; i<N; i++){
                Arrays.fill(dist[i], INF);
            }

            dist[0][0] = map[0][0];

            Queue<Locate> q = new LinkedList<>();
            q.add(new Locate(0, 0));

            while(!q.isEmpty()){
                Locate cur = q.poll();

                for(int i=0; i<4; i++){
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if(nextR >= N || nextC >= N || nextR <= -1 || nextC <= - 1) continue;

                    if(dist[nextR][nextC] > dist[cur.r][cur.c] + map[nextR][nextC]){
                        dist[nextR][nextC] = dist[cur.r][cur.c] + map[nextR][nextC];
                        q.add(new Locate(nextR, nextC));
                    }
                }
            }

            System.out.print("Problem " + idx + ": ");
            System.out.println(dist[N-1][N-1]);

            idx++;
            
            
        }

		// StringTokenizer st = new StringTokenizer(br.readLine());

		// N = Integer.parseInt(st.nextToken());				

		// dist = new int[N+1];
		// list = new ArrayList[N+1];
        

		// for(int i=1; i<N+1; i++){
		// 	list[i] = new ArrayList<>();			
		// }
		
		// for(int i=1; i<M+1; i++){
		// 	st = new StringTokenizer(br.readLine());	

		// 	int from = Integer.parseInt(st.nextToken());
		// 	int to = Integer.parseInt(st.nextToken());
		// 	int weight = Integer.parseInt(st.nextToken());

		// 	list[from].add(new Edge(to, weight));
		// }

		
		// dijkstra(start);

		// for(int i=1; i<N+1; i++){
		// 	if(dist[i] == INF){
		// 		System.out.println("INF");
		// 	}else{
		// 		System.out.println(dist[i]);
		// 	}
		// }
		
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
				if(dist[info.idx] + e.weight >= dist[e.to]){
					continue;
				}

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

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r=r;
        this.c=c;
    }
}