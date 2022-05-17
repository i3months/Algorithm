import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean prime[] = new boolean[1_000_001];		

		int N = 1_000_000;
		prime[0] = prime[1] = true;

		for(int i=2; i*i <= N; i++){
			if(!prime[i]){
				for(int j = i * i; j<= N; j = i + j){
					prime[j] = true;
				}
			}
		}

/*		ArrayList<Integer> sosu = new ArrayList<>();
		
		for(int i=2; i*i<=N; i++){			
				if(!prime[i]){					
					for(int j=i*i; j<=N; j+=i){
						prime[j] = true;                
					} 
				}        
		}		

		for(int i=0; i<1_000_001; i++){
			if(!prime[i]){
				sosu.add(i);
			}
		}	
*/		
		

		while(true){
			int M = Integer.parseInt(br.readLine());

			if(M == 0){
				break;
			}
			
			int a = 0;
			int b = 0;

			for(int i=3; i<M; i++){

				if(!prime[i]){
					if(!prime[M - i]){
						a = i;
						b = M - i;
						break;
					}
				}

			}
/*
			for(int i=0; i<M; i++){

				int temp = M - sosu.get(i);
				if(sosu.contains(temp)){
					if(temp > sosu.get(i)){
						a = sosu.get(i);
						b = temp;
						break;
					}else{
						a = temp;
						b = sosu.get(i);
						break;
					}
				}	
							
			}
*/
			if(a == 0 && b == 0){
				sb.append("Goldbach's conjecture is wrong.\n");
			}else{
				sb.append(M + " = " + a + " + " + b + "\n");
			}			
			//System.out.println(M + " = " + a + " + " + b);

		}
		

		System.out.println(sb);

		
		
		
	}
	
}
