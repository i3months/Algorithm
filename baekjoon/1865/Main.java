import java.io.*;
import java.util.*;

public class Main {

	static int N, M, W;
	static int[] dist;	
	static ArrayList<Portal>[] list;
	static int INF = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
		  M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			dist = new int[N + 1];
			
			list = new ArrayList[N + 1];

			for(int j=1; j<N + 1; j++){
				list[j] = new ArrayList<>();
			}

			for(int j=0; j<M + W; j++){
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				if(j < M){
					list[start].add(new Portal(end, cost));
					list[end].add(new Portal(start, cost));
				}else{
					list[start].add(new Portal(end, -cost));
				}		
			}
		
			if(bf()){
				sb.append("YES\n");
			}else{
				sb.append("NO\n");
			}
			
		}

		System.out.println(sb);

		
	}

	static boolean bf(){

		for(int i=2; i<N+1; i++){
			dist[i] = INF;
		}

		boolean chk = false;

		for(int i = 1; i< N; i++){
			chk = false;

			for(int j=1; j<N+1; j++){
				for(int k = 0; k < list[j].size(); k++){
					Portal tmp = list[j].get(k);
					if(dist[tmp.destination] > dist[j] + tmp.cost){
						dist[tmp.destination] = dist[j] + tmp.cost;
						chk = true;
					}
				}
			}

			if(!chk){
				break;
			}
		}

		if(chk){
			for(int i=1; i<N+1; i++){
				for(int k = 0; k <list[i].size(); k++){
					Portal tmp = list[i].get(k);
					if(dist[tmp.destination] > dist[i] + tmp.cost){
						return true;
					}
				}
			}
		}

		return false;
		
	}
}

class Portal{
	int destination, cost;

	Portal(int a, int b){
		destination = a;
		cost = b ;
	}
}