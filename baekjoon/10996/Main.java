import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		
		
		char[][] arr = new char[N*2][N];

		for(int i=0; i<N*2; i++){
			for(int j=0; j<N; j++){
				arr[i][j] = ' ';
			}
		}

		for(int i=0; i<N*2; i++){
			for(int j=0; j<N; j++){
				if(i % 2 == 0){
					if(j % 2 == 0){
						arr[i][j] = '*';
					}
				}else if(i % 2 == 1){
					if(j % 2 == 1){
						arr[i][j] = '*';
					}
				}
			}
		}
		

		for(int i=0; i<N*2; i++){
			for(int j=0; j<N; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}