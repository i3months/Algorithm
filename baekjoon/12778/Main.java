import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			String M = st.nextToken();			

			st = new StringTokenizer(br.readLine());

			if(M.equals("C")){
				for(int j=0; j<N; j++){
					sb.append(st.nextToken().charAt(0) - 'A' + 1 + " ");
				}
			}else{
				for(int j=0; j<N; j++){
					char temp = (char)(Integer.parseInt(st.nextToken()) + 'A' - 1);
					sb.append(temp + " ");
				}
			}
			sb.append("\n");	
			
		}
		System.out.println(sb);		
		
	}
}