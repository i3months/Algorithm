import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		
		
		char[][] arr = new char[N][N*2];

		for(int i=0; i<N; i++){
			for(int j=0; j<N*2; j++){
				arr[i][j] = ' ';
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N*2; j++){
				if(i % 2 == 0){
					if(j%2 == 0){
						arr[i][j] = '*';
					}
				}else if(i % 2 ==1){
					if(j % 2 ==1){
						arr[i][j] ='*';
					}
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N*2; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
}