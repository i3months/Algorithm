import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String s1 = br.readLine();
      String cal = br.readLine();
      String s2 = br.readLine();

      BigInteger b1 = new BigInteger(s1);
      BigInteger b2 = new BigInteger(s2);

      if(cal.equals("*")){
        System.out.print(b1.multiply(b2));
      }else{
        System.out.print(b1.add(b2));
      }
      
    }
}