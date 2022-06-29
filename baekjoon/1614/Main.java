import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		
		long N = Long.parseLong(br.readLine());

		long limit = Long.parseLong(br.readLine());

		long ans = 0;

		if(N == 1) {
			ans = (long)(limit*8);
	}else if(N == 2) {
			ans = (long)(1+(limit/2)*8+(limit%2)*6);
	}else if(N == 3) {
			ans = (long)(2+(limit/2)*8+(limit%2)*4);
	}else if(N == 4) {
			ans = (long)(3+(limit/2)*8+(limit%2)*2);
	}else {
			ans = (long)(4 + limit*8);
	}
	System.out.println(ans);
		
	}
}