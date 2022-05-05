import java.util.*;
import java.io.*;

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String str = br.readLine();

			int Gcnt = 0;
			int Bcnt = 0;

			for(int j=0; j<str.length(); j++){
				if(str.charAt(j) == 'G' || str.charAt(j) == 'g'){
					Gcnt++;
				}else if(str.charAt(j) == 'B' || str.charAt(j) == 'b'){
					Bcnt++;
				}
			}

			if(Gcnt > Bcnt ){
				System.out.println(str + " is " + "GOOD");
			}else if (Gcnt < Bcnt){
				System.out.println(str + " is A " + "BADDY");
			}else{
				System.out.println(str + " is " + "NEUTRAL");
			}

		}


	}

}