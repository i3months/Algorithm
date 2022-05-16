import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(solve(A,B,C));

		
		
		
	}

	static long solve(long a, long b, long c){

		if(b == 1){ // base condition
			return a % c;
		}

		long val = solve(a, b/2, c); // a^2k -> a^k -> a^k/2 ... 
		
		val = (val * val) % c;

		if(b % 2 == 0){ // 짝수면 그대로 
			return val;
		}

		return (val * a) % c; // 홀수면 한 번 더 곱해줘야 함
	}
}