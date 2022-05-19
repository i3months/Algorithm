import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());

			String asdf = st.nextToken();
			if(asdf.equals("*")){
				break;
			}

			asdf = asdf.charAt(0) + "";
			String ans = asdf.toUpperCase();

			boolean chk = false;

			while(st.hasMoreTokens()){
				String temp = st.nextToken();
				String temp2 = temp.charAt(0) + "";
				temp2 = temp2.toUpperCase();

				if(!temp2.equals(ans)){
					System.out.println("N");
					chk = true;
					break;					
				}			
		
				
			}
			if(!chk){
				System.out.println("Y");
			}
			

			
		}
	}
}