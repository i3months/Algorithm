import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static int INF = 987654321;

	static int N, M, start, T, H, G;
	static int[] dist;
	static ArrayList<Edge>[] list;	
    static ArrayList<Integer> candidate;

    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
    
            dist = new int[N+1];
            list = new ArrayList[N+1];
            candidate = new ArrayList<>();
    
            for(int i=1; i<N+1; i++){
                list[i] = new ArrayList<>();			
            }

            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            for(int i=1; i<M+1; i++){
                st = new StringTokenizer(br.readLine());	
    
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
    
                list[from].add(new Edge(to, weight));
                list[to].add(new Edge(from, weight));
            }            
                
            dijkstra(start);

            for(int i=0; i<T; i++){
                candidate.add(Integer.parseInt(br.readLine()));
            }
    
            // for(int i=1; i<N+1; i++) System.out.print("dist : " + dist[i] + " "); System.out.println();

            int[] min_dist = new int[N + 1];

            for(int i=1; i<N+1; i++){
                min_dist[i] = dist[i];
            }

            int g_to_h = 0;
            int start_to_g = dist[G];            
            int start_to_h = dist[H];
            
            dijkstra(G);
            g_to_h = dist[H];
            int[] g_to_cand = new int[N + 1];          
            for(int i=1; i<N+1; i++){
                g_to_cand[i] = dist[i];
            }
            dijkstra(H);
            int[] h_to_cand = new int[N + 1];
            for(int i=1; i<N+1; i++){
                h_to_cand[i] = dist[i];
            }

            
            ArrayList<Integer> to_remove = new ArrayList<>();

            for(int i=0; i<T; i++){                
                int g_to_cand1 = g_to_cand[candidate.get(i)];
                int is_min_dist = start_to_h + g_to_h + g_to_cand1;
                int h_to_cand1 = h_to_cand[candidate.get(i)];
                int is_min_dist2 = start_to_g + g_to_h + h_to_cand1;

                int mmm = Math.min(is_min_dist, is_min_dist2);

                // System.out.println("debug : " + min_dist[candidate.get(i)] + " " + mmm);
                if(mmm != min_dist[candidate.get(i)]){                                    
                    to_remove.add(candidate.get(i));
                }
            }
            
            for(int k : to_remove){
                Integer z = new Integer(k);
                candidate.remove(z);
            }

            // dijkstra(H);
            // T = candidate.size();
            // to_remove = new ArrayList<>();

            // for(int i=0; i<T; i++){
            //     int h_to_cand = dist[candidate.get(i)];

            //     int is_min_dist = start_to_g + g_to_h + h_to_cand;
            //     System.out.println("debug : " + min_dist[candidate.get(i)] + " " + is_min_dist);
            //     if(is_min_dist != min_dist[candidate.get(i)]){
            //         // candidate.remove(candidate.get(i));                    
            //         to_remove.add(candidate.get(i));
            //     }
            // }     

            // for(int k : to_remove){
            //     Integer z = new Integer(k);
            //     candidate.remove(z);
            // }

            Collections.sort(candidate);

            
            
            for(int k : candidate){
                // System.out.print(k + " ");

                sb.append(k + " ");
            }
            sb.append("\n");
            // System.out.println();
            

            
            

            
        }		

        System.out.println(sb);
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

    // @Override
    // public boolean equals(Object o2){
    //     Edge o3 = (Edge)o2;

    //     if(to == o3.to && )
    // }
}

class Info implements Comparable<Info>{
	int idx, dist;
    	
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