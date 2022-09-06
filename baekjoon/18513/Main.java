import java.io.*;
import java.util.*;

public class Main {		
	static int N, K;

	static PriorityQueue<Lake> pq = new PriorityQueue<>();
	static boolean[] visit1 = new boolean[200_000_001];
	static boolean[] visit2 = new boolean[200_000_001];

	static int[] dx = {-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			int a = Integer.parseInt(st.nextToken());
			pq.add(new Lake(a, 0));

			if(a < 0){
				visit1[a * -1] = true;
			}else{
				visit2[a] = true;
			}			
		}

		long cnt = 0;
		long ans = 0;

		while(!pq.isEmpty()){
			Lake cur = pq.poll();

			for(int i=0; i<2; i++){
				int nextX = cur.x + dx[i];				

				if(nextX < 0){
					if(visit1[-1 * nextX]){
						continue;
					}
				}else{
					if(visit2[nextX]){
						continue;
					}
				}

				cnt++;
				ans += cur.dist + 1;
				
				if(cnt == K){
					System.out.println(ans);
					return;
				}

				if(nextX < 0){
					visit1[-1 * nextX] = true;
				}else{
					visit2[nextX] = true;
				}

				pq.add(new Lake(nextX, cur.dist + 1));
			}
			
		}

		

		
	}
}

class Lake implements Comparable<Lake>{
	int x, dist;

	Lake(int x, int dist){
		this.x = x;
		this.dist = dist;
	}

	@Override
	public int compareTo(Lake o2){
		return Integer.compare(dist, o2.dist);
	}
}