import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, 1, N+1);

		int ans = Integer.MAX_VALUE;		
		int R = 1;

		for(int L = 1; L< N+1; L++){
			
			while(R < N && arr[R] - arr[L] < K){
					R++;					
			}			

			if(arr[R] - arr[L] >= K){
				ans = Math.min(ans, arr[R] - arr[L]);
			}

		}

		System.out.println(ans);


	}
}