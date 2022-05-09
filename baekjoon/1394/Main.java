import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String code = br.readLine();

		int sequence[] = new int[400];

		for(int i=1; i<code.length() + 1; i++){
			sequence[code.charAt(i - 1)] = i;
		}

		String password = br.readLine();

		int control = 1;
		int ans = 0;
		int cnt = code.length();

		for(int i = password.length() - 1; i>=0; i--){
			ans = (ans + control * sequence[password.charAt(i)]) % 900528;
			control = control * cnt % 900528;
		}

		System.out.println(ans);
		
		

	}
}