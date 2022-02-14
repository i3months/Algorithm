import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] S = new String[N];
		String[] arr = new String[M];

		for(int i=0; i<N; i++){
			S[i] = br.readLine();
		}

		for(int i=0; i<M; i++){
			arr[i] = br.readLine();
		}
		int count = 0;

		for(int i=0; i<N; i++){
			for(int j =0; j<M; j++){
				if(S[i].equals(arr[j])){
					count++;
				}
			}
		}

		

		System.out.println(count);
	}

	
}