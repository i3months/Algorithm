import java.io.*;
import java.util.*;

public class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
			
		String s1 = br.readLine();
		String s2 = br.readLine();

		long max = 0;

		long[][] dp = new long[s1.length() + 1][s2.length() + 1];

		for(int i=1; i<s1.length()+1; i++){
			for(int j=1; j<s2.length()+1; j++){
				if(s1.charAt(i-1) == s2.charAt(j-1)){	
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(dp[i][j], max);
				}
			}
		}

		System.out.println(max);

		// for(int i=1; i<s1.length()+1; i++){
		// 	for(int j=1 ;j<s2.length()+1; j++){
		// 		System.out.print(dp[i][j] + " ");
		// 	}System.out.println();
		// }
		
	}
}
