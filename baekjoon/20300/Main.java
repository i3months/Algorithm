import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());			

			long[] arr = new long[N];

			for(int i=0; i<N; i++){
				arr[i] = Long.parseLong(st.nextToken());
			}

			Arrays.sort(arr);

			long M = -1;

			if(N % 2 == 0){ // even num
				int L = 0;
				int R = N-1;

				while(L < R){
					long tmp = (long)arr[L] + arr[R];

					if(tmp >= M){
						M = tmp;
					}
					L++;
					R--;					
				}
			}else{ // odd num 
				M = (long)arr[N-1];
				int L = 0;
				int R = N-2;
				while(L < R){
					long tmp = (long)arr[L] + arr[R];

					if(tmp > M){
						M = tmp;
					}
					L++;
					R--;
				}

			}

			System.out.println(M);

	}
}