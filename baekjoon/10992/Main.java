import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N-i+1 ; j++) {
				sb.append(" ");
			}
			
			for (int j = 1; j <= i+(i-1); j++) {
				if(j%2==0)
					sb.append(" ");
				else
					sb.append("*");
			}
			sb.append('\n');
		}

    bw.write(sb.toString());
    bw.close();
	}
}