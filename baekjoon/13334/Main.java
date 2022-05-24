import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		Distance[] arr = new Distance[N];
		
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Distance(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr);

		int len = Integer.parseInt(br.readLine());

		int ans = 0;
		int max = -1;

		for(int i=0; i<N; i++){
			pq.offer(arr[i].start);
			
			while(!pq.isEmpty() && pq.peek() < arr[i].fin - len){
				pq.poll();
			} 
			
			max = Math.max(max, pq.size());
		}
		
		System.out.println(max);
	}
}

class Distance implements Comparable<Distance>{
	int start;
	int fin;

	Distance(int a, int b){
		int max = Math.max(a,b);
		int min = Math.min(a,b);

		start = min;
		fin = max;
	}

	public int compareTo(Distance o2){
		return fin - o2.fin;
	}
}