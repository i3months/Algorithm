import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for(int i=N-1; i>=0; i--){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> dq = new ArrayDeque<>();

		int num = 1;
		int temp = 0;

		for(int i=0; i<N; i++){
			int skill = arr[i];
			if(skill==1){
				dq.offerFirst(num);
			}else if(skill==2){
				temp = dq.pollFirst();
				dq.addFirst(num);
				dq.addFirst(temp);
			}else if(skill == 3){
				dq.addLast(num);
			}
			num = num + 1;
		}
		StringBuilder sb = new StringBuilder();

		while(true){
			if(dq.isEmpty()){
				break;
			}

			sb.append(dq.remove() + " ");
		}

		System.out.print(sb);



	}
}