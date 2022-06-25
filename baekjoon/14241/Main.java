import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			PriorityQueue<Integer> pq = new PriorityQueue<>();

			for(int i=0; i<N; i++){
				pq.add(Integer.parseInt(st.nextToken()));
			}

			int sum = 0;

			while(true){
				if(pq.size() == 1){
					break;
				}

				int a = pq.poll();
				int b = pq.poll();

				pq.add(a + b);
				sum = sum + (a * b);
			}

			System.out.println(sum);
		
	}
}