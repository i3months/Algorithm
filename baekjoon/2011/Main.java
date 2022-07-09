import java.util.*;
import java.io.*;
import java.math.*;

public class Main{		
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int N = str.length();

		int[] dp = new int[N];

		if(str.charAt(0) != '0'){
			dp[0] = 1;
		}

		for(int i=1; i<N; i++){
			if(str.charAt(i) != '0'){
				dp[i] = dp[i-1];
			}

			if(chk(str.charAt(i-1), str.charAt(i))){
				if(i== 1){
					dp[i]++;
				}else{
					dp[i] = dp[i] + dp[i-2];
				}

				dp[i] = dp[i] % 1000000;
			}
		}


		System.out.println(dp[N-1]);
		
	}

	static boolean chk(char a, char b){
		if(a == '1'){			
			return true;
		}

		if(a == '2' && b <= '6'){		
			return true;
		}		

		return false;


	}


}