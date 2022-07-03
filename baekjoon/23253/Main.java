import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());				

		for(int i=0; i<M; i++){
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());			
			int val = Integer.MAX_VALUE;

			for(int j=0; j<K; j++){
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > val){
					System.out.println("No");
					return;
				}	
				val = tmp;
			}
			
		}				

		System.out.println("Yes");
		
	}
}
