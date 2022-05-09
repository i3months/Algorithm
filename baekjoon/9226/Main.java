import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String str = br.readLine();
			String origin = str;
			if(str.equals("#")){
				break;
			}

			if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u'){
				System.out.println(str + "ay");
			}else{
				str = str.substring(1,str.length()) + str.charAt(0);
				for(int i=0; i<str.length(); i++){
					if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u'){
						System.out.println(str + "ay");
						break;
					}else{
						str = str.substring(1,str.length()) + str.charAt(0);
					}

					if(i == str.length()-1){
						str = str.substring(1,str.length()) + str.charAt(0);
						System.out.println(origin + "ay");
					}
				}
			}
		}

	}
}