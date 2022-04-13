import java.util.*;
import java.io.*;

public class Main1 {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		String str = String.valueOf(N);

		for(int i=0; i<N; i++){
			sb.append(str);
		}

		if(sb.length() > M){
			System.out.println(sb.substring(0, M));
		}else{
			System.out.println(sb);
		}

		


 
		
	}
}