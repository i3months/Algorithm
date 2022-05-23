import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int idx = 1;

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());

			long L = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			long V = Long.parseLong(st.nextToken());

			if(L == 0 && P == 0 && V == 0){
				break;
			}

			long ans = 0;

			long tmp = V / P;
			long tmp2 = V % P;

			if(tmp2 == 0){
				ans = ans + tmp * L;
			}else if(tmp2 < L){
				ans = ans + tmp * L + tmp2;
			}else if(tmp2 >= L){
				ans = ans + tmp * L + L;
			}

			System.out.printf("Case %d: %d\n", idx, ans);
			idx++;
			
			
		}
				
	}
}