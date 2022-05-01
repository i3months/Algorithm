	import java.util.*;
	import java.io.*;
	
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			String str = br.readLine();

			String str2 = "";

			if(str.charAt(0) == '0' && str.charAt(1) == 'x'){
				str2 = str.substring(2, str.length());
				System.out.println(Integer.valueOf(str2, 16));
			}else if(str.charAt(0) == '0'){
				str2 = str.substring(1, str.length());
				System.out.println(Integer.valueOf(str2, 8));
				
			}else{
				str2 = str;
				System.out.println(Integer.valueOf(str2, 10));
			}

			
			
		}
	}