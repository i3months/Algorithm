import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int a = 2;

		for(int i=0; i<N; i++){
			a = a + (int)Math.pow(2,i);
		}

		System.out.println((int)Math.pow(a,2));


	}
}