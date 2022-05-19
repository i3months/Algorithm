import java.util.*;
import java.io.*;

public class Main {

	static int[] arr = new int[10_000_001];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		int arr2[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = arr[i];
		}


		Arrays.sort(arr2);

		int rank = 0;
		HashMap<Integer, Integer> hm = new HashMap<>();

		for(int i=0; i<N; i++){
			int temp = arr2[i];

			if(!hm.containsKey(temp)){
				hm.put(temp, rank);
				rank++;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++){
			int temp = arr[i];
			int rank_val = hm.get(temp);
			sb.append(rank_val + " ");			
		}
		System.out.println(sb);
		


		
	}
}