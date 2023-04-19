import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static final int INF = 987654321;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
		
		int TC = Integer.parseInt(br.readLine());

		while(TC-- > 0) {
			int ans = 0;
			String str = br.readLine();
			if(str.charAt(0) != '^') {
				str = "^" + str; ans++;
			}

			if(str.charAt(str.length()-1) != '^') {
				str = str + "^"; ans++;
			}

			String[] arr = str.split("\\^+");

			if(str.length() == 1 && str.charAt(0) == '^') {
				sb.append(1 + "\n");
				continue;
			}

			for(String k : arr) {
				if(k.equals("")) {
					continue;
				}
				ans += k.length()-1;
			}

			sb.append(ans + "\n");
		}

		System.out.println(sb);

    }
}
