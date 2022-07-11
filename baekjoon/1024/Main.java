import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long L = Long.parseLong(st.nextToken());

		StringBuilder sb = new StringBuilder();

		for(long i=L; i<101; i++){
			for(long j=0; j<N - L + 1; j++){ // N - L?
				
				long tmp = j + i;

				long a = ((tmp) * (tmp-1)) / 2;
				long b = ((j) * (j-1)) / 2;

				long sum = a - b;

				//System.out.println(sum);

				if(sum > N){
					break;
				}

				if(sum == N){
					for(long k = j; k < tmp; k++){
						sb.append(k + " ");
					}	
					System.out.println(sb);
					return;
				}

			}

			
		}

		System.out.println(-1);


	}
}