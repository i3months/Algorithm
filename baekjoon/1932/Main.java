import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		for(int i= N-1; i>0; i--){
			for(int j=0; j<i; j++){
				arr[i-1][j] = arr[i-1][j] + Math.max(arr[i][j], arr[i][j+1]);
			}
		}

		System.out.println(arr[0][0]);

		

	}
}