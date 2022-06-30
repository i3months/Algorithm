import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	
		static int[] arr;
		static int[][] dp;
		static int[][] sum;
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			int T = Integer.parseInt(br.readLine());				

			for(int i=0; i<T; i++){				
				StringTokenizer st = new StringTokenizer(br.readLine());
				BigInteger b1 = new BigInteger(st.nextToken());
				BigInteger b2 = new BigInteger(st.nextToken());
				System.out.println(b1.add(b2));
			}
			
	}
}