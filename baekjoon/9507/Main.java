import java.util.*;
import java.io.*;

public class Main {

	static long arr_koong[] = new long[68];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		arr_koong[0] = 1;
		arr_koong[1] = 1;
		arr_koong[2] = 2;
		arr_koong[3] = 4;

		for (int i = 0; i < K; i++) {
			int temp = Integer.parseInt(br.readLine());
			System.out.println(koong(temp));
		}

	}

	static long koong(int n) {	

		if(arr_koong[n] != 0){
			return arr_koong[n];
		}

		for(int i=4; i<=n; i++){
			arr_koong[i] = arr_koong[i-1] + arr_koong[i-2] + arr_koong[i-3] + arr_koong[i-4];			
		}

		return arr_koong[n];


	}



}