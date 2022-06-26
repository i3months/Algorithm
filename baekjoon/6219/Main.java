import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());


			boolean[] prime = new boolean[B+1];

			prime[0] = prime[1] = true;

			for(int i=2; i * i <= B; i++){
				if(!prime[i]){
					for(int j= i*i; j<=B; j= j + i){
						prime[j] = true;
					}
				}
			}

			int cnt = 0;
			for(int i=A; i<B+1; i++){

				if(!prime[i]){
					int tmp = i;

				while(tmp != 0){
					if(tmp % 10 == D){
						cnt++;
						break;
					}
					tmp = tmp / 10;
				}
				}				
			}

			System.out.println(cnt);
	}
}