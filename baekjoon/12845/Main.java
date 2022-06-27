import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
		
		int N = Integer.parseInt(br.readLine());
		
		int score = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];

		int max = 0;
		int idx = 0;

		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]){
				max = arr[i];
				idx = i;
			}
		}	

		for(int i=0; i<N; i++){
			if(i!=idx){
				score = score + max + arr[i];
			}
		}
		System.out.println(score);
			
	}
}