import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());

			int[] arr = new int[N];;

			st = new StringTokenizer(br.readLine());

			for(int i=0; i<N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int[] arr2 = new int[N+1];

			arr2[0] = 0;
			arr2[1] = arr[0];

			for(int i=2; i<N+1; i++){
				arr2[i] = arr2[i-1] + arr[i-1];
			}

			StringBuilder sb = new StringBuilder();

			for(int i=0; i<Q; i++){
				st = new StringTokenizer(br.readLine());

				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());

				sb.append(arr2[R] - arr2[L - 1] + "\n");

			}


			
			System.out.println(sb);
	}
}