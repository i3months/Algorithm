import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[M];

		st=  new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int L = 1;
		int R = arr[M-1];
		int ans = 0;

		while(L <= R){
			int mid = (L + R) / 2;
			int cnt = 0;
			
			for(int i=0; i<M; i++){
				cnt = cnt + (arr[i] / mid);
			}

			if(cnt >= N){
				ans = mid;
				L = mid + 1;
			}
			if(cnt < N){
				R = mid - 1;
			}
		}
			
		System.out.println(ans);
	}	
}