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
			String str = br.readLine();			

			if(!str.contains("0")) {
				int aa = str.length();
				BigInteger b1 = new BigInteger(String.valueOf(aa));
				b1 = b1.multiply(b1);
				sb.append(b1.toString() + "\n");
				continue;
			}

			String[] arr = str.split("0+");

			long cnt = 0;

			ArrayList<String> list = new ArrayList<>();

			for(String k : arr) {
				if(k.equals("")) continue;
				list.add(k);
				cnt = Math.max(cnt, k.length());
			}

			if(str.charAt(0) == '1' && str.charAt(str.length()-1) == '1') {
				long num = list.get(0).length() + list.get(list.size()-1).length();
				cnt = Math.max(cnt, num);
			}

			long ans = -1;			
			
			if(cnt % 2 == 0) {
				long a = (cnt / 2);
				long b = (cnt / 2) + 1;
				ans = a * b;				
			} else {
				long a = (cnt / 2) + 1;
				long b = (cnt / 2) + 1;
				ans = a * b;					
			}			
			sb.append(ans + "\n");
		}

		System.out.print(sb);
    }
}
