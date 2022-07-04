import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				

		StringTokenizer st = new StringTokenizer(br.readLine())			;

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		double[] arr = new double[N+1];

		arr[0] = (double)A/B;

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());

			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			arr[i+1] = (double)tmp1 / tmp2;
		}
		Arrays.sort(arr);
		System.out.println(arr[0] * 1000);
	

	}
}
