import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int max = 0;

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		long ans = Integer.MIN_VALUE;

		for(int i=1; i<max+1; i++){
			long sum = 0;
			for(int j=0; j<N; j++){
				int cut = 0;								
				
				if(arr[j] >= i){
					if(arr[j] % i == 0){
						cut = arr[j] / i - 1;
					}else{
						cut = arr[j] / i;
					}

					if(W * i * (arr[j] / i) - (cut * C) > 0){
						sum = sum + (W * i * (arr[j] /i) - (cut * C));
					}
				}
			}
			ans = Math.max(ans, sum);
		}		
		System.out.println(ans);

	}
}