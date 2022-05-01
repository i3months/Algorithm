	import java.util.*;
	import java.io.*;
	
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int N = Integer.parseInt(br.readLine());

			for(int i=0; i<N; i++){
				String str = br.readLine();
				str = str.toUpperCase();				

				int idx = str.length() -1 ;

				boolean chk = false;

				for(int j=0; j<str.length(); j++){

					if(j >= str.length() / 2){
						break;
					}

					if(str.charAt(j) == str.charAt(idx)){			
						idx--;
						chk = true;			
					}else{
						chk = false;
						break;
					}

				}

				if(chk){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}




			}

		}
	}