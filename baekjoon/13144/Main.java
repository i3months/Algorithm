import java.util.*;
import java.io.*;
 
public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
 
		int[] arr = new int[N+1];
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
 
		int[] count = new int[100_001];
 
		long ans = 0;
		
		int R = 0;
	
		for(int L = 1; L<N+1; L++){
 
			while(R + 1 < N+1 && count[arr[R+1]] == 0){
				R++;
				count[arr[R]]++;
			} 
 
			ans = ans + R - L + 1;
 
			count[arr[L]]--;
 
 
		}
 
		System.out.println(ans);
		
 
	}
}