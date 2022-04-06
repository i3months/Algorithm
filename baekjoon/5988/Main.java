import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            BigInteger b1 = new BigInteger(str);
            
            if (b1.remainder(new BigInteger("2")).equals(new BigInteger("0"))) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }

        }

    }
}