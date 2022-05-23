import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		long[] arr = new long[K];
		TreeSet<Long> ts = new TreeSet<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < K; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				ts.add(arr[i]);
		}		
			
		long tmp = 0;
		long max = arr[K-1];

		boolean chk = false;

		while(true){
			if(N <= 0){
				break;
			}
			tmp = ts.pollFirst();

			for(int i=0; i<K; i++){

				if(tmp * arr[i] >= Integer.MAX_VALUE){
					//chk = true;
					break;
				}

				if(ts.size() > N && tmp * arr[i] > max){					
					break;
				}

				ts.add(tmp * arr[i]);
				max = Math.max(max, tmp*arr[i]);
			}

			if(chk){
				break;
			}

			N--;
		}

		System.out.println(tmp);		

		

	}
}