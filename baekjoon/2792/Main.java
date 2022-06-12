import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> color_num = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0; i<M; i++){
			color_num.add(Long.parseLong(br.readLine()));
		}

		while(true){
			if(color_num.size() == N){
				break;
			}
			long tmp = color_num.poll();

			color_num.add(tmp / 2);
			color_num.add(tmp / 2 + tmp % 2);
		}

		System.out.println(color_num.peek());

	}	
}