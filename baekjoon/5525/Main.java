import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String S = br.readLine();

		int cnt = 0;
		
		String comp = solve(N);

		for(int i=0; i<S.length(); i++){
			int len = i + comp.length();
			if(len >= S.length()){
				break;
			}
			int idx = 0;

			for(int j=i; j<len; j++){
				if(S.charAt(j) != comp.charAt(idx)){
					break;
				}

				if(j == len-1){
					cnt++;
				}
				idx++;
			}
		}
		System.out.println(cnt);

	}

	static String solve(int n){
		if(n == 1){
			return "IOI";
		}

		return solve(n-1) + "OI";
	}
}