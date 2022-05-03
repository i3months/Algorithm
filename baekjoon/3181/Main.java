import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int cnt = 1;

		while(st.hasMoreTokens()){
			String str = st.nextToken();
			
			if(cnt == 1){
				if(str.equals("i") || str.equals("pa") || str.equals("te") || str.equals("ni") || str.equals("niti") || str.equals("a") || str.equals("ali") || str.equals("nego") || str.equals("no") || str.equals("ili")){
					sb.append(str.charAt(0));
				}else{
					sb.append(str.charAt(0));
				}
			}else{
				if(str.equals("i") || str.equals("pa") || str.equals("te") || str.equals("ni") || str.equals("niti") || str.equals("a") || str.equals("ali") || str.equals("nego") || str.equals("no") || str.equals("ili")){
					continue;
				}else{
					sb.append(str.charAt(0));
				}
			}

			cnt++;
			
			
		}

		System.out.println(sb.toString().toUpperCase());
		
	}
}
