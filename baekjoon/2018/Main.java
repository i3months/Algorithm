import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		int cnt = 1;

		for(int i=1; i<N /2 + 1; i++){
			sum = 0;
			for(int j = i; sum<N; j++){
				sum = sum + j;
				if(sum == N){
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);

		
	}		
}
