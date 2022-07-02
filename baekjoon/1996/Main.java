import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	static int[] dr = {1,-1,0,0,1,1,-1,-1};
	static int[] dc = {0,0,1,-1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		int[][] map2 = new int[N][N];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<N; j++){
				if(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
					map[i][j] = str.charAt(j) - '0';
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){

				for(int k=0; k<8; k++){
					int nr = i + dr[k];
					int nc = j + dc[k];

					if(nr <= -1 || nr >= N || nc <= -1 || nc >= N){
						continue;
					}					

					map2[nr][nc] = map2[nr][nc] + map[i][j];						
					
				}
				

			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j] != 0){
					System.out.print("*");
				}else{
					if(map2[i][j] >= 10){
						System.out.print("M");
					}else{
						System.out.print(map2[i][j]);
					}
				}				
			}
			System.out.println();
		}
	

		
	}		
}
