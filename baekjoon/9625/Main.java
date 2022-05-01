import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		BABBA temp = new BABBA(1, 0);

		for(int i = 0; i<K; i++){

			int origin = temp.B;

			temp.B = temp.B + temp.A;
			temp.A = temp.A - temp.A; // a - b

			

			temp.A = temp.A + origin;
		}

		System.out.println(temp.A + " " + temp.B);
		
	}
}

class BABBA{
	int A = 0;
	int B = 0;

	BABBA(int a, int b){
		A = a;
		B = b;
	}
}