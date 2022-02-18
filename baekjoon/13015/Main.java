import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		

		char[][] arr = new char[N*2-1][(N-1)*2-1+(2*N)];

		for(int i=0; i<2*N-1; i++){
			for(int j=0; j<(N-1)*2-1+(2*N); j++){
				arr[i][j] = ' ';
			}
		}

		
		
		for(int i=0; i<2*N-1; i++){
			for(int j=0; j<(N-1)*2-1+(2*N); j++){
				if(i == 0 || i == 2*N-2){
					if(j<N || j>=(N-1)*2-1+(2*N)-1-(N-1)){
						arr[i][j] = '*';
					}
				}else if(i == N-1){
					if(j == 2*N-1-1 || j == 2*N-1-1 - (N-2+1) || j == 2*N-1-1 +(N-2+1)){
						arr[i][j] = '*';
					}
				}else if(i<=N-1){
					if(j == 2*N-2 - (N-i-2+1) || j == 2*N-2 + (N-i-2+1) || j == 2*N-2 -(N-i-2+1) - (N-2+1) || j == 2*N-2 + (N-i-2+1) + (N-2+1)){
						arr[i][j] = '*';
					}
				}else{
					if(j == 2*N-2 - (i-(N-2)+(N-2)) || j == 2*N-2 + (i-(N-2)+(N-2)) || j == 2*N-2 -(i-(N-2)+(N-2)) + (N-2+1) || j == 2*N-2 + (i-(N-2)+(N-2)) - (N-2+1)){
						arr[i][j] = '*';
					}
				}
			}
		}


	loop1: for(int i=0; i<2*N-1; i++){
			int check = 0;
		  for(int j=0; j<(N-1)*2-1+(2*N); j++){
				if(i == 0 || i == 2*N-2 || i == N-1){
					if(i == N-1){
						if(arr[i][j] == '*'){
							check++;
							System.out.print(arr[i][j]);
						
							if(check==3){
								System.out.println();
								continue loop1;
							}
						}else{
							System.out.print(arr[i][j]);
						}
					}else{
						System.out.print(arr[i][j]);
						continue;
					}
				
				}else{
					if(arr[i][j] == '*'){
						check++;
						System.out.print(arr[i][j]);
						
						if(check == 4){
							System.out.println();
							continue loop1;
						}
					}else{
						System.out.print(arr[i][j]);
					}
				}

			}
			System.out.println();
		}

	} 
}