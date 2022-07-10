import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      

				StringTokenizer st = new StringTokenizer(br.readLine());

				int N = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				
				int cnt = 0;

				while(A != B){
					A = A / 2 + A % 2;
					B = B / 2 + B % 2;
					cnt++;
				}

				System.out.println(cnt);
    }
}