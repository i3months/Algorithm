import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
			
			int N = Integer.parseInt(br.readLine());
			int K = Integer.parseInt(br.readLine());			
			int cnt = 0;

			int[] arr = new int[N+1];

			for(int i=2; i<N+1; i++){
				if(arr[i] != 0){
					continue;
				}

				for(int j=i; j<N+1; j=j+i){
					arr[j] = Math.max(arr[j], i);
				}
			}
			for(int i=1; i<N+1; i++){
				if(arr[i] <= K){
					cnt++;
				}
				
			}
			System.out.println(cnt);
	}	
}