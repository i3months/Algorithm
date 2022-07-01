import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	
		static int[] arr;
		static int[][] dp;
		static int[][] sum;
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int i=0; i<N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int target = Integer.parseInt(br.readLine());

			Arrays.sort(arr);

			boolean chk = false;

			int L = 0;
			int R = Integer.MAX_VALUE;

			for(int i=0; i<N; i++){
				if(arr[i] > target){
					R = Math.min(R, arr[i]);
				}else if(arr[i] < target){
					L = Math.max(L, arr[i]);
				}else{
					chk = true;
					break;
				}
			}

			if(chk){
				System.out.println(0);
			}else{
				int ans = (target - L - 1) + (R - target - 1) + ((target - L - 1) * (R - target - 1));
				System.out.println(ans);
			}
			
	}
}