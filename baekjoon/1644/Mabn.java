import java.util.*;
import java.io.*;

public class Mabn {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] prime_chk = new boolean[N + 1];

		ArrayList<Integer> prime = new ArrayList<>();

		prime_chk[0] = true;
		prime_chk[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime_chk[i]) {
				continue;
			}

			for (int j = i * i; j < prime_chk.length; j = j + i) {
				prime_chk[j] = true;
			}
		}

		for(int i = 0; i<prime_chk.length; i++){
			if(!prime_chk[i]){
				prime.add(i);			
			}
		}


		int R = -1; // -1??
		int ans = 0;
		int sum = 0;

		for(int L = 0; L<prime.size(); L++){

			while(R < prime.size()-1 && sum < N){				
				R++;
				sum = sum + prime.get(R);				
				
				if(sum == N){
					ans++;
					break;
				}
			}

			sum = sum - prime.get(L);

			if(sum == N){
				ans++;
			}
		}

		System.out.println(ans);

	}
}