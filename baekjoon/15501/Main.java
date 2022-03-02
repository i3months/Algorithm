import java.io.*;
import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;
 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		Deque<Integer> dq = new ArrayDeque<>();
		Deque<Integer> dq2 = new ArrayDeque<>();

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st1.nextToken());
		}


		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++){
			int temp = Integer.parseInt(st2.nextToken());
			dq.addLast(temp);
			dq2.addLast(temp);
		}



		for(int i=0; i<N; i++){
			if(arr[0] == dq.getFirst()){
				break;
			}else{
				dq.addLast(dq.pollFirst());
				dq2.addLast(dq2.pollFirst());
			}
		}

		boolean able = false;

		for(int i=0; i<N; i++){
			if(arr[i] == dq.getFirst()){
				if(i == N-1){
					able = true;
				}
				dq.addLast(dq.pollFirst());
			}else{
				break;
			}
		}

		for(int i=0; i<N; i++){
			if(arr[i] == dq2.getFirst()){
				if(i == N-1){
					able = true;
				}
				dq2.addFirst(dq2.pollLast());
			}else{
				break;
			}
		}

		if(able){
			System.out.println("good puzzle");
		}else{
			System.out.println("bad puzzle");
		}


	}
}