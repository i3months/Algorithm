	import java.util.*;
	import java.io.*;
	
	public class Main {
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			int N = Integer.parseInt(br.readLine());

			if(powchk(N)){
				System.out.println(1);
			}else{
				System.out.println(0);
			}

			
			
			
		}
		static boolean powchk(int n){

				for(int i=0; i<31; i++){
					long temp = (long)Math.pow(2,i);
					if(temp == n){
						return true;

					}
				}

				return false;
		}
	}