import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());

		int sum = 0;

		int start = 1;
		int end = 1;

		int cnt = 0;

		

		while(true){
			//ArrayList<Integer> list = new ArrayList<>();
			sum = 0;

			for(int i=start; i<=end; i++){
				sum = sum + i;
				//list.add(i);
			}

			if(sum == N){
				cnt++;
				start++; 
				// for(int k : list){
				// 	System.out.print(k + " ");
				// }
				// System.out.println();
			}

			if(sum < N){
				end++;
			}

			if(sum > N){
				start++;
			}

			if(end == N+1 || start == N+1){
				break;
			}
		}

		System.out.println(cnt);

		
	}		
}
