import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1 == abs2){
				if(o1 > o2){
					return 1;
				}else{
					return -1;
				}
			}else{
				if((abs1-abs2)<0){
					return -1;
				}else{
					return 1;
				}
			}
		});

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