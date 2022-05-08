import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());		
		}

		Arrays.sort(arr, 1, N+1);

		long ans = Long.MAX_VALUE;

		long first = 0;
		long second = 0;
		long third = 0;

		for(int i = 1; i< N -1; i++){
			long target = -1 * arr[i];
			int L = i+1;
			int R = N;

			while(L < R){
				if(ans > Math.abs(-1 * target + arr[L] + arr[R])){
					ans = Math.abs(-1 * target + arr[L] + arr[R]);
					first = -1 * target;
					second = arr[L];
					third = arr[R];
				}			
				
				if(arr[L] + arr[R] > target){
					R--;
				}else{
					L++;
				}
			}			
			
			
		}

		System.out.println(first + " " + second + " " + third);

		

	}
}