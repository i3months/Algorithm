import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MIN_VALUE;		
				
		int L = 1;
		int R = K;

		while(true){
			if(R == N+1){
				break;
			}
			int sum = 0;

			for(int i = L; i<R+1; i++){
				sum = sum + arr[i];
			}

			ans = Math.max(ans, sum);

			L++;
			R++;

			
		}

		System.out.println(ans);
		

		

	}
}