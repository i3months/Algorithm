import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger b1 = new BigInteger(br.readLine());

        if(b1.compareTo(new BigInteger("1")) == 0){
            System.out.println(1);
        }else if(b1.compareTo(new BigInteger("2")) == 0){
            System.out.println(2);
        }else{
            System.out.println(b1.add(b1.subtract(new BigInteger("2"))));;
        }
        
        
    }
}