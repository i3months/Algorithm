import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BigInteger N = new BigInteger(br.readLine());
		BigInteger start = new BigInteger("1");
		BigInteger end = N;
		BigInteger mid;

		while (true) {
			mid = start.add(end);
			mid = mid.divide(new BigInteger("2"));

			int result = (mid.multiply(mid)).compareTo(N);

			if (result == 0){ // 같으면 끝
				break;
			}else if (result == 1){
				end = mid.subtract(new BigInteger("1")); // 크면 end 조절
			}else{
				start = mid.add(new BigInteger("1")); // 작으면 start 조절
			}			

		}

		System.out.println(mid.toString());
	}
}