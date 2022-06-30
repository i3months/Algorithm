import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
			
			String str = br.readLine();

			long ans = 0;

			for(int i=0; i<str.length(); i++){
				int a = str.charAt(i) - '0';

				ans = ans + (int)Math.pow(a, 5);
			}

			System.out.println(ans);
			
			
			
	}
}