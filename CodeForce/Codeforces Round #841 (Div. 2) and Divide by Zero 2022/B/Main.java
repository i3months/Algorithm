import java.io.*;
import java.util.*;
import java.math.*;
 
public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            N = Integer.parseInt(br.readLine());
            String n = String.valueOf(N);
            String n1 = String.valueOf(N-1);
            String n2 = String.valueOf(2*N+1);
            String n3 = String.valueOf(N+1);

            BigInteger b1 = new BigInteger(n);  
            b1 = b1.multiply(new BigInteger(n3));            
            b1 = b1.multiply(new BigInteger(n2));            
            b1 = b1.divide(new BigInteger("6"));

            BigInteger b2 = new BigInteger(n);
            b2 = b2.multiply(new BigInteger(n1));
            b2 = b2.multiply(new BigInteger(n3));
            b2 = b2.divide(new BigInteger("3"));

            b1 = b1.add(b2);
            b1 = b1.multiply(new BigInteger("2022"));
            b1 = b1.mod(new BigInteger("1000000007"));

            String ans = b1.toString();
            
            sb.append(ans + "\n");
        }

        System.out.println(sb);


    }   
}

class Locate {
    int r, c;
    Locate(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
