import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());

		int[] arr= new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;

		long[] sum_arr = new long[N-1];


		sum_arr[0] = arr[0];

		for(int i=1; i<N-1; i++){
			sum_arr[i] = sum_arr[i-1] + arr[i];
		}

		for(int i=1; i<N; i++){
			sum += arr[i] * sum_arr[i-1];
		}

		System.out.println(sum);
		
		

			
	}
}