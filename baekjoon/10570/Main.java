import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		

		

		for(int i=0; i<N; i++){
			int[] arr = new int[5000];

			int max = -1;
			int V = Integer.parseInt(br.readLine());
			
			for(int j=0; j<V; j++){
				int temp = Integer.parseInt(br.readLine());
				arr[temp]++;				

				if(arr[temp] > max){
					max = arr[temp];
				}

			}

			ArrayList<Integer> list = new ArrayList<>();

			for(int j=0; j<5000; j++){
				if(arr[j] == max){
					list.add(j);
				}
			}

			Collections.sort(list);

			sb.append(list.get(0) + "\n");

		}		
		
		System.out.print(sb);
		

	}

}