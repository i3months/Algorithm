import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        BigInteger c = new BigInteger(br.readLine());

        BigInteger d = b.subtract(c);
        BigInteger e = d.divide(a);
        System.out.println(e);
        
        
        
    }
}
