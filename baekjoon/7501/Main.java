import java.io.*;
import java.util.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
        
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        BigInteger A = new BigInteger(s1);
        BigInteger B = new BigInteger(s2);        

        while(true){         
        
            if(A.compareTo(B.add(BigInteger.ONE)) == 0){                                
                break;
            }

            if(A.compareTo(new BigInteger("9")) == 0){
                sb.append("9" + " ");
            }else if(A.isProbablePrime(512)){
                sb.append(A + " ");
            }


            A = A.add(BigInteger.ONE);                        
        }
        
        System.out.println(sb);
    }
}
