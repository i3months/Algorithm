import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N =Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String a = br.readLine();
			String b = br.readLine();
			String ans = "";
			char[] arr = new char[9999];
			for(int j=0; j<b.length(); j++){
				arr[j] = b.charAt(j);
			}

			for(int j=0; j<a.length(); j++){
				if(a.charAt(j) == ' '){
					ans = ans + ' ' + "";
				}else{
					ans = ans + "" + arr[a.charAt(j) - 'A'];
				}
			}
			System.out.println(ans);
		}
		
	}
}