import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			boolean chk = false;

			for(int j= x; j< N * M; j = j + M){
				if(j % N == y){
					System.out.println(j + 1);
					chk = true;
					break;
				}
			}

			if(!chk){
				System.out.println(-1);
			}
		}
	}
}