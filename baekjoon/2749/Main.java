import java.util.*;
import java.io.*;
import java.math.*;

public class Main{	

	static long arr[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());

		int cycle = 1_000_000 / 10 * 15;

		arr = new long[cycle];

		arr[0] = 0;
		arr[1] = 1;

		for(int i=2; i<cycle; i++){
			if(i > N){
				break;
			}
			arr[i] = (arr[i-1] + arr[i-2]) % 1_000_000;
		}

		N = N % cycle;

		System.out.println(arr[(int)N]);

	}
}