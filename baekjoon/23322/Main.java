import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N+1];

			st = new StringTokenizer(br.readLine());

			for(int i=1; i<N+1; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, 1,N+1);
			

			int day = 0;
			int eat = 0;

			for(int i= K+1; i<N+1; i++){
				while(true){
					if(arr[i] != arr[i - K]){
						eat = eat + (arr[i] - arr[i - K]);
						day++;
						arr[i] = arr[i - K];
						Arrays.sort(arr, 1, N+1);
					}else{
						break;
					}
				}
			}

			System.out.println(eat + " " + day);


	}
}