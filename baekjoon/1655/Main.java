import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<N; i++){
			int command = Integer.parseInt(br.readLine());

			if(min.size() == max.size()){
				max.add(command);
			}else{
				min.add(command);
			}

			if(min.isEmpty()==false && max.isEmpty() == false){
				if(min.peek() < max.peek()){
					int temp = min.poll();
					min.add(max.poll());
					max.add(temp);
				}
				
			}
			sb.append(max.peek()).append('\n');
		}

		System.out.println(sb);



	}
}