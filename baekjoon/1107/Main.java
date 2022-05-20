import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];

		if(M != 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++){
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		

		int min = Math.abs(N - 100);

		for(int i=0; i<1_000_002; i++){
			String str = String.valueOf(i);
			int len = str.length();

			boolean brk = false;

			for(int j=0; j<len ;j++){
				if(broken[str.charAt(j) - '0']){
					brk = true;
					break;
				}
			}

			if(!brk){
				int temp = Math.abs(N - i) + len;
				min = Math.min(min, temp);
			}

		}

		System.out.println(min);
		

	}
}