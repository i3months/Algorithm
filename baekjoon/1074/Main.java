import java.util.*;
import java.io.*;
 
public class Main {
	 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		System.out.println(solve(N,R,C));	
 
	}

	static int solve(int n, int r, int c){
		if(n == 0){ // base condition
			return 0; // 1이 아니고 0으로 설정했음
		}

		int half = (int)Math.pow((double)2, (double)n-1);

		if(r < half && c < half){ // area 1
			return solve(n-1, r, c);
		}

		if(r < half && c >= half){ // area 2
			return half * half + solve(n-1, r, c-half);
		}

		if(r >= half && c < half){ // area 3
			return 2* half * half + solve(n-1, r-half, c);
		}

		return 3 * half * half + solve(n-1, r-half, c-half); // area 4
	}
}