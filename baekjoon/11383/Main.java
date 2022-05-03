import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for(int i=0; i<N; i++){
			String str = br.readLine(); // 
			for(int j=0; j<M; j++){
				arr[i][j] = str.charAt(j);
			}
		}

		int[][] arr2 = new int[N][M*2];

		for(int i=0; i<N; i++){
			String str = br.readLine(); // 
			for(int j=0; j<M*2; j++){
				arr2[i][j] = str.charAt(j);
			}
		}

		int[][] arr3 = new int[N][M*2];
		

		int k = 0;

		for(int i=0; i<N; i++){			
			for(int j=0; j<M; j++){
				int temp = arr[i][j];
				
				arr3[i][k] = temp;
				arr3[i][k+1] = temp;
				k = k + 2;
			}
			k = 0;
		}


		/////////////////////

		for(int i=0; i<N; i++){
			for(int j=0; j<M*2; j++){
				System.out.print((char)arr3[i][j]);
			}
			System.out.println();
		}

		/////////////////

		boolean chk = true;

		for(int i=0; i<N; i++){
			for(int j=0; j<M*2; j++){
				if(arr3[i][j] != arr2[i][j]){
					chk = false;
					break;
				}
			}
		}

		if(chk){
			System.out.println("Eyfa");
		}else{
			System.out.println("Not Eyfa");
		}


	}
}
