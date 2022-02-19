import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		for(int i=0; i<0; i++){
			System.out.println(arr[i]);
		}


	}
}