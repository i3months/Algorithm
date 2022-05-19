import java.util.*;
import java.io.*;

public class Main {

	static int[] arr = new int[10_000_001];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr[1] = 5;
		arr[2] = 12;
		arr[3] = 22;		

		System.out.println(solve(N));

		

	}
	static int solve(int n){

		if(arr[n] != 0){
			return arr[n];
		}

		arr[n] = (solve(n-1) + (n+1)*3 -2 ) % 45678;
		
		return arr[n];
		
	}
}