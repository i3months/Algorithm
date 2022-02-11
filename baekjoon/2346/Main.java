import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Deque<array> dq = new ArrayDeque<>();

		for(int i=1; i<N+1; i++){
			dq.add(new array(i, Integer.parseInt(st.nextToken())));
		}

		while(true){
			if(dq.size()==1){
				break;
			}
			array temp = dq.pollFirst();
			int cycle = temp.cycle;
			sb.append(temp.index).append(" ");

			if(cycle==1){
				dq.addFirst(dq.pollLast());
			}else if(cycle==-1){
				dq.addLast(dq.pollFirst());
			}else if(cycle>0){
				for(int i=1; i<cycle; i++){
					dq.addFirst(dq.pollLast());
				}
			}else{
				cycle = cycle * -1;
				for(int i=0; i<cycle; i++){
					dq.addLast(dq.pollFirst());
				}
			}

		}

		sb.append(dq.poll().index);

		System.out.println(sb);
		



		

	}

	static class array{
		int index = 0;
		int cycle = 0;

		array(int a, int b){
			index = a;
			cycle = b;
		}
	}
}