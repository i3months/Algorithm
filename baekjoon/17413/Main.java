import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		boolean check = false;
		ArrayList<Character> list = new ArrayList<>();

		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='<'){
				sb.append('<');
				check = true;
			}	
			

			if(check){
				if(str.charAt(i)=='>'){
					check = false;
					sb.append('>');
				}else{
					if(str.charAt(i)=='<'){
						
					}else{
						sb.append(str.charAt(i));
					}
					
				}
			}else{
				if(str.charAt(i)==' ' || i==str.length()-1 || (i<str.length()-1 && str.charAt(i+1)=='<')){
					if(str.charAt(i)==' '){
						Collections.reverse(list);
					}else{
						list.add(str.charAt(i));
						Collections.reverse(list);
					}
				
					for(int j=0; j<list.size(); j++){
						sb.append(list.get(j));
					}

					if((i<str.length()-1 && str.charAt(i+1)=='<')){
						list.clear();
					}else{
						sb.append(' ');
						list.clear();
					}
				
				}else{
					list.add(str.charAt(i));
				}
			}

			

			
		}

		System.out.print(sb);

	}
}