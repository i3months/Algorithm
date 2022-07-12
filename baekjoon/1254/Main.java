import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		String str = br.readLine();

		int len = str.length();

		for(int i=0; i<str.length(); i++){
			if(check(str.substring(i, str.length()))){
				break;
			}
			len++;
		}

		System.out.println(len);

		
		

	}

	static boolean check(String s){
		int start = 0;
		int end = s.length()-1;

		while(start <= end){
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}

			start++;
			end--;
		}
		return true;
	}
}