import java.util.*;
import java.io.*;

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
    //Arrays.sort(arr);

		int ans = Integer.MAX_VALUE;

		int left_ans = 0;
		int right_ans = 0;

		int L = 0;
		int R = N-1;

		while(L < R){
			int sum = arr[L] + arr[R];

			if(Math.abs(sum) < ans){
				ans = Math.abs(sum);
				left_ans = arr[L];
				right_ans = arr[R];
			}

			if(sum > 0){
				R--;
			}else{
				L++;
			}

		}

		System.out.println(left_ans + " " + right_ans);

		
		

	}
}