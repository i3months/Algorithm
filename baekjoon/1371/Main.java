import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
		String str = "";
		
		while((input = br.readLine()) != null) {
			str = str + input;
		}
		
		int max = 0;
		String str_max = "";
		
		for(char i = 97; i < 123; i++) {
			int count = str.length() - str.replace(String.valueOf(i), "").length();
            // 해당 문자가 없을 때 길이를 빼면 해당 문자의 길이를 얻을 수 있다
			if(max == count) {
				str_max += String.valueOf(i);
			}
			
			if(max < count) {
				max = count;
				str_max = String.valueOf(i);
			}
		}

		System.out.println(str_max);
	}

}