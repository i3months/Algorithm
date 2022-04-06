import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine(), ",");
       int sum = 0;
       while(st.hasMoreTokens()){
        int a = Integer.parseInt(st.nextToken());

        sum = sum + a;
       }
       System.out.println(sum);
    }
}