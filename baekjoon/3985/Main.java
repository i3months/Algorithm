import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		int L = Integer.parseInt(br.readLine());

		int N = Integer.parseInt(br.readLine());

		int[] cake = new int[L+1];

		int max_customer_expected = 0;
		int max_customer_expected_check = 0;
		int max_customer_real = 0;

		for(int i=0; i<L+1; i++){
			cake[i] = 0;
		}

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if(max_customer_expected_check < K-P+1){
				max_customer_expected_check = K-P+1;
				max_customer_expected = i;
			}

			for(int j = P; j<K+1; j++){
				if(cake[j] == 0 ){
					cake[j] = i;
				}
			}

		}

		int[] customer_arr = new int[N+1];

		for(int i=1; i<L+1; i++){
			if(cake[i] != 0){
				customer_arr[cake[i]] ++;
			}
		}

		int max_customer_real_check = 0;
		for(int i=1; i<N+1; i++){
			if(max_customer_real_check < customer_arr[i]){
				max_customer_real_check = customer_arr[i];
				max_customer_real = i;
			}
		}

		System.out.println(max_customer_expected);
		System.out.println(max_customer_real);

	}
}

		
