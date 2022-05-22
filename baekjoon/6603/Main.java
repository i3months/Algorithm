import java.util.*;
import java.io.*;

public class Main {	

	static int k = 0;
	static int[] arr;
	static int[] ans = new int[15];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if(k == 0){
				break;
			}

			arr = new int[k];

			int idx = 0;		
			while(st.hasMoreTokens()){
				arr[idx] = Integer.parseInt(st.nextToken());
				idx++;
			}

			solve(0,0);
			System.out.println();
		}
		
		
	}

	private static void solve(int start, int depth) {
		if(depth == 6) {
			for(int i=0; i<k; i++){
				if(ans[i] == 1){
					System.out.print(arr[i] + " ");
				}				
			}
			System.out.println();
			return;
		}

		for(int i = start; i < k; i++) {
			ans[i] = 1;
			solve(i+1, depth+1);						
			ans[i] = 0;
		}
	}
}