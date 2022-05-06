import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;

	static int[] arr;
	static int[] selected;
	static int[] used;	

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1];
		used = new int[N+1];
		selected = new int[M+1];

		st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, 1, N+1);

		solve(1);

		System.out.println(sb);

		

		
	}

	static void solve(int k){
		if(k == M + 1){
			for(int i=1; i<M+1; i++){
				sb.append(selected[i] + " ");
			}
			sb.append("\n");
		}else{

			int last_idx = 0;
			for(int i=1; i<N+1; i++){
				if(used[i] == 1){
					continue;
				}
				if(arr[i] == last_idx){
					continue;
				}

				last_idx = arr[i];
				selected[k] = arr[i];
				used[i] = 1;

				solve(k+1);

				selected[k] = 0;
				used[i] = 0;
			}
		}
		
	}
}