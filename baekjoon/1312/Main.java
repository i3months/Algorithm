import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			Double A = Double.parseDouble(st.nextToken());
			Double B = Double.parseDouble(st.nextToken());
			Integer N = Integer.parseInt(st.nextToken());

			Double tmp = A % B;

			for(int i=0; i<N-1; i++){
				tmp = tmp * 10;
				tmp = tmp % B;
			}
			tmp = tmp * 10;

			System.out.println( (int)(tmp / B));
	}	
}