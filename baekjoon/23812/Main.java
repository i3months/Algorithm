import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		
		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[N*5][N*5];

		for(int i=0; i<N*5; i++){
			for(int j=0; j<N*5; j++){
				arr[i][j] = '@';
			}
		}

		int check = 0;

		for(int i=0; i<N*5; i++){
			check++;
			if(check==N*2+1){
				check = 1;
			}
			for(int j =0; j<N*5; j++){
				if(check<=N){
					if(j>N-1 && j<N*5-N){
						arr[i][j] = ' ';
					}
				}
			}
		}


		for(int i=0; i<N*5; i++){
			for(int j=0; j<N*5; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}

		
