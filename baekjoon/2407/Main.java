import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());			

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			BigInteger n1 = BigInteger.ONE;
			BigInteger n2 = BigInteger.ONE;

			for (int i = 0; i < m; i++) {
					n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
					n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
			}

			BigInteger answer = n1.divide(n2);

			System.out.println(answer);
	}
}