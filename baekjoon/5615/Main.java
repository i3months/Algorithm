import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder(); 
	static int[] arr = {2,3,5,7,11};    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
        int TC = Integer.parseInt(br.readLine());

		int cnt = 0;

		while(TC-- >0){
			
			long N = Long.parseLong(br.readLine());
			long num = N * 2 + 1;

			BigInteger b = new BigInteger(String.valueOf(num));

			if(b.isProbablePrime(10)){
				cnt++;
			}

			
			

				

		}

		System.out.println(cnt);

    


	}
}