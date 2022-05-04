import java.util.*;
import java.io.*;

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, 1, N+1);

		int ans = 2147483647;
		int left_ans = 0;
		int right_ans = 0;

		for(int i=1; i<N+1; i++){
			int result_idx = BinarySearch(arr, i+1, N, -1 * arr[i]);

			if(i + 1 <= result_idx - 1 && result_idx - 1 <= N && Math.abs(arr[result_idx - 1] + arr[i]) < ans){
				ans = Math.abs(arr[result_idx - 1] + arr[i]);
				left_ans = arr[i];
				right_ans = arr[result_idx - 1];
			}

			if(i + 1 <= result_idx && result_idx <= N && Math.abs(arr[result_idx] + arr[i]) < ans){
				ans = Math.abs(arr[result_idx] + arr[i]);
				left_ans = arr[i];
				right_ans = arr[result_idx];
			}

			
		}


		System.out.println(left_ans + " " + right_ans);

		

	}

	static int BinarySearch(int[] arr, int L, int R, int target){
			int result = R + 1;

			while(L <= R){
				int mid = (L + R) / 2;
				if(arr[mid] >= target){
					result = mid;
					R = mid - 1;
				}else{
					L = mid + 1;
				}
			}

			return result;
	}
}