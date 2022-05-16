import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[][] map;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];		

		for(int i=0; i<N; i++){
			String str = br.readLine();	
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}

/*
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
*/

		//sb.append("(");

		solve(0,0,N);

		System.out.println(sb);

		
		
	
	}

	static void solve(int r, int c, int size){

		if(check(r,c,size)){			
			sb.append(map[r][c]);
			return;
		}

		int size2 = size / 2;

		sb.append("(");
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				solve(r + i * size2, c + j * size2, size2);
			}
		}
		sb.append(")");

		return;

	}

	static boolean check(int r, int c, int size){

		for(int i=r; i<r+size; i++){
			for(int j=c; j<c+size; j++){
				if(map[i][j] != map[r][c]){
					return false;
				}
			}
		}
	
		return true;
	}
}