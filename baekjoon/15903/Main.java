import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());		

		st = new StringTokenizer(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>();

		for(int i=0; i<N; i++){
			pq.add(Long.parseLong(st.nextToken()));
		}

		for(int i=0; i<M; i++){
			long temp = pq.poll();
			long temp2 = pq.poll();

			long tmp = temp + temp2;
			pq.offer(tmp);
			pq.offer(tmp);
		}

		long ans = 0;

		while(!pq.isEmpty()){
			ans = ans + pq.poll();
		}
	
		System.out.println(ans);	

	}
}