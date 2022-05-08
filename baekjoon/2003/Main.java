import java.util.*;
import java.io.*;
 
public class Main{			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];

		st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		

		int R = 1;
		int sum = arr[1];
		int ans = 0;

		if(sum == M){
			ans++;
		}

		for(int L = 1; L < N+1; L++){					
						
			while(R < N){
				
				if(sum + arr[R+1] > M){										
					break;
				}

				if(sum + arr[R+1] == M){			
					ans++;		
					break;
				}

				if(sum + arr[R+1] < M){
					R++;
					sum = sum + arr[R];					
				}
				
			}
			
			sum = sum - arr[L];

			if(sum == M){
				ans++;
			}
			

		}

		System.out.println(ans);
				 		
	}
}