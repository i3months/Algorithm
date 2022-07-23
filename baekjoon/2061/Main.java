import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        boolean[] primes = new boolean[l + 1];
        primes[1] = true;
              
        for(int i = 2 ; i < l ; i++){
            if(primes[i]) continue; 
            BigInteger now = new BigInteger(Integer.toString(i));
            if(k.mod(now).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("BAD " + now);
                return;
            }
            for(int j = i + i ; j <= l ; j += i){ 
                primes[j] = true;
            }
        }
        System.out.println("GOOD");
        
 
    }
 
}
 
