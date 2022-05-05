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

		int X = Integer.parseInt(br.readLine());

		Arrays.sort(arr, 1, N+1);

		int ans = 0;

		for(int i = 1; i<N; i++){
			if(BinarySearch(arr, i + 1, N, X - arr[i])){
				ans++;
			}
		}

		System.out.println(ans);
				

	}
	
	static boolean BinarySearch(int[] arr, int L, int R, int target){
		while(L <= R){
			int mid = (L + R) / 2;

			if(arr[mid] == target){
				return true;
			}

			if(arr[mid] < target){
				L = mid + 1;
			}else{
				R = mid - 1;
			}
		}

		return false;
	}

	

}