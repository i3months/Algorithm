import java.util.*;
import java.io.*;
 
public class Main{	

	static int[] alpha;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		String str = br.readLine();

		alpha = new int[27];

		int R = 0;

		int ans = 0;

		for(int L = 0; L<str.length(); L++){

			int len = 0;		

			while(R + 1 <= str.length()){				
				alpha[str.charAt(R) - 'a']++;
				R++;

				if(alpha_check()){					
					R--;
					alpha[str.charAt(R) - 'a']--;					
					break;
				}

			}

			len = R - L + 1;

			ans = Math.max(ans, len);

			alpha[str.charAt(L) - 'a']--;

			


		}

		System.out.println(ans-1);
		
 
	}

	static boolean alpha_check(){
		int cnt = 0;
		for(int i=0; i<27; i++){
			if(alpha[i] != 0){
				cnt++;
			}
		}

		return cnt > N;
	}
}