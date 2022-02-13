import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for(int i=0; i<N; i++){
			int command = Integer.parseInt(br.readLine());

			if(command == 0){
				if(q.isEmpty()){
					sb.append(0).append('\n');
				}else{
					sb.append(q.poll()).append('\n');
				}
			}else{
				q.offer(command);
			}
		}

		System.out.println(sb);




	}
}