import java.util.*;
import java.io.*;

public class Main{	
  
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean chk = false;
    String str = br.readLine();

		for(int i=1; i<str.length(); i++){
			String tmp1 = str.substring(0,i);
			String tmp2 = str.substring(i,str.length());
					

			int a = 1;
			int b = 1;
			for(int j=0; j<tmp1.length(); j++){
				a = a * (tmp1.charAt(j) - '0');
			}
			for(int j=0; j<tmp2.length(); j++){
				b = b * (tmp2.charAt(j) - '0');
			}

			if(a == b){
				chk = true;
				break;
			}

			//System.out.println(a);
			//System.out.println(b);
		}
    

		if(chk){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
    

	}
}