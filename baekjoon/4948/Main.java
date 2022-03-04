import java.io.*;
import java.util.*;

public class Main {
	
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true){
			int n = Integer.parseInt(br.readLine());

			if(n == 0){
				break;
			}
			
			cnt = 0;

			for(int i = n+1; i<=2*n; i++){
				prime_check(i);
			}

			sb.append(cnt).append('\n');
			

	}

	System.out.println(sb);
}

	static void prime_check(int num){
		if(num < 2){
			return;
		}

		if(num == 2){
			cnt++;
			return;
		}

		for(int i = 2; i<= Math.sqrt(num); i++){
			if(num % i == 0){
				return;
			}
		}

		cnt++;


	}
}