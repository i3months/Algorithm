import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
      
		String str = br.readLine();

		int[] alpha = new int[27];

		for(int i=0; i<str.length(); i++){
			alpha[str.charAt(i) - 'A']++;
		}

		int cnt = 0;

		for(int i=0; i<27; i++){
			if(alpha[i] % 2 == 1){
				cnt++;		
			}
		}
			
		if(cnt >= 2){
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		StringBuilder sb = new StringBuilder();

		if(cnt == 0){
			
			for(int i=0; i<27; i++){
				int cycle = alpha[i];

				for(int j=0; j<cycle / 2; j++){
					sb.append((char)(i + 'A'));	
				}							
			}

			StringBuilder sb2 = new StringBuilder();

			sb2.append(sb.toString() + sb.reverse());

			System.out.println(sb2);

			return;
		}

		

		int odd = 0;

		for(int i=0; i<27; i++){
			if(alpha[i] % 2 == 1){
				odd = i;
			}
				int cycle = alpha[i];
				
				for(int j=0; j<cycle / 2; j++){
					sb.append((char)(i + 'A'));	
				}
						
		}

		int odd_cnt = alpha[odd];

		StringBuilder sb2 = new StringBuilder();

		sb2.append(sb.toString());
		
			sb2.append((char)(odd + 'A'));		

		sb2.append(sb.reverse());

		System.out.println(sb2);







	}
}