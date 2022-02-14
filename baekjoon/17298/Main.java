import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> stackidx = new Stack<>();

		int[] arr = new int[N];
		int[] ans = new int[N];

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
	
		for(int i=0; i< N; i++){
			while(stack.size()>0 && stack.peek() < arr[i]){
				ans[stackidx.peek()] = arr[i];
				stack.pop();
				stackidx.pop();
			}
			stack.push(arr[i]);
			stackidx.push(i);
		}

		while(stackidx.size()>0){	
			ans[stackidx.peek()] = -1;
			stackidx.pop();
		}

		ans[N-1] = -1;

		for(int i=0; i<N; i++){
			sb.append(ans[i]).append(" ");
		}

		

		System.out.print(sb);
	}

	
}