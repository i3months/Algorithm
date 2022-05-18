import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}		

		for(int i=1; i<N ;i++){
			int a = arr[0];
			int b = arr[i];											

			int temp = gcd(a, b);

			System.out.println(a / temp + "/" + b / temp);
		}

	}

	static int gcd(int a, int b){
		int remain = 0;

		while(b != 0){
			remain = a % b;
			a = b;
			b = remain;
		}
		return a;
	}
}