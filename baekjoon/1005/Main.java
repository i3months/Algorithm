import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			StringBuilder sb = new StringBuilder();

			ArrayList<Integer>[] adj;
			int[] indeg;
			int[] time;
			int[] time2;

			int T = Integer.parseInt(br.readLine());

			for(int i=0; i<T; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());

				int N = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				adj = new ArrayList[N+1];
				time = new int[N+1];
				time2 = new int[N+1];
				indeg = new int[N+1];

				for(int j=1; j<N+1; j++){
					adj[j] = new ArrayList<>();
				}

				st = new StringTokenizer(br.readLine());

				for(int j=1; j<N+1; j++){
					time[j] = Integer.parseInt(st.nextToken());
				}

				for(int j=0; j<K; j++){
					st = new StringTokenizer(br.readLine());

					int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());

					adj[x].add(y);
					indeg[y]++;
				}

				Deque<Integer> dq = new LinkedList<>();
				
				for(int j=1; j<N+1; j++){
					if(indeg[j] == 0){
						dq.add(j);
						time2[j] = time[j];
					}
				}

				while(!dq.isEmpty()){
					int x = dq.pollFirst();

					for(int y : adj[x]){
						indeg[y]--;

						if(indeg[y] == 0){
							dq.add(y);
						}

						time2[y] = Math.max(time2[y], time2[x] + time[y]);

					}
				}

				int target = Integer.parseInt(br.readLine());

				sb.append(time2[target] + "\n");

			}


			System.out.println(sb);

			
			
	}
}