import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int K;

	static int max = Integer.MIN_VALUE;

	static int[] liter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		K = Integer.parseInt(st.nextToken());

		liter = new int[N+1];

		for(int i=1; i<N+1; i++){
			liter[i] = Integer.parseInt(br.readLine());
			if(max < liter[i]){
				max = liter[i];
			}
		}

		BinarySearch();



	}

	static boolean check(long l){
		long cnt = 0;

		for(int i=1; i<N+1; i++){
			cnt = cnt + liter[i] / l;
		}

		return cnt >= K;

	}

	static void BinarySearch(){
		long L = 1;
		long R = max;
		long ans = 0;

		while(L <= R){
			long mid = (L+R) / 2;
			if(check(mid)){
				ans = mid;
				L = mid + 1;
			}else{
				R = mid - 1;
			}
		}

		System.out.println(ans);
	}

}