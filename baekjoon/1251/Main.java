import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
			
			String str = br.readLine();

			ArrayList<String> list = new ArrayList<>();

			for(int i=1; i<str.length(); i++){
				for(int j= i+1; j<str.length(); j++){
					StringBuilder a1 = new StringBuilder();
					StringBuilder a2 = new StringBuilder();
					StringBuilder a3 = new StringBuilder();
					
					a1.append(str.substring(0,i));
					a2.append(str.substring(i,j));
					a3.append(str.substring(j,str.length()));

					StringBuilder a4 = new StringBuilder();					

					a4.append(a1.reverse().toString());
					a4.append(a2.reverse().toString());
					a4.append(a3.reverse().toString());

					list.add(a4.toString());
				}
			}

			Collections.sort(list);
			
			System.out.println(list.get(0));
			
	}
}