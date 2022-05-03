import java.util.*;
import java.io.*;

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for(int i=0; i<T; i++){
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int arr1[] = new int[N];
			int arr2[] = new int[M+1];

			st = new StringTokenizer(br.readLine());

			for(int j=0; j<N; j++){
				arr1[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			for(int j=1; j<M+1; j++){
				arr2[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr2); // 먹이에 대해 이분탐색 진행

			int ans = 0;

			for(int j=0; j<N; j++){
				ans = ans + search(arr2, 1, M, arr1[j]);
			}

			System.out.println(ans);
			

		}


	}

	static int search(int[] arr, int L, int R, int X){
		// arr 배열의 L ~ R 인덱스 중 X미만의 수 중 제일 오른쪽거를 찾기.
		
		int result = 0;

		while(L <= R){

			int mid = ((L + R) / 2);

			if(arr[mid] < X){
				result = mid;	
				L = mid + 1;				
			}else if(arr[mid] >= X){
				R = mid - 1;
			}

		}

		return result;

	}
}