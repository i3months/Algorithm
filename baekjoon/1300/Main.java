import java.util.*;
import java.io.*;

public class Main {

	static long N;
	static long K;	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Long.parseLong(br.readLine());		
		K = Long.parseLong(br.readLine());		
		
		BinarySearch();
		
		
	}

	static boolean check(long p){
		long sum = 0;

		for(int i = 0; i<N; i++){
			sum = sum + Math.min(N, p / (i+1));
		}

		return sum >= K;
	}

	static void BinarySearch(){
		long L = 0;
		long R = N*N;
		long ans = 0;

		while(L <= R){
			long mid = (L + R)/2;
			if(check(mid)){
				ans = mid;
				R = mid - 1;
			}else{
				L = mid + 1;
			}
		}

		System.out.println(ans);
	}

}