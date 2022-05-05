import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		

		for(int i=0; i<10; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int last = Integer.parseInt(st.nextToken()) - 1;
			
			int idx_last = last;
			for(int j=start; j<last + 1; j++){
				int temp = arr[j];
				arr[j] = arr[last];
				arr[last] = temp;
				last--;
			}
			
		}

		for(int i=0; i<20; i++){
			System.out.print(arr[i] + " ");
		}

		

			
	}

}