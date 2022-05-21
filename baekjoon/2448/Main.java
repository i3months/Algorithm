import java.util.*;
import java.io.*;

public class Main {	
	static int N;
	static char[][] map;
	static char[][] basis = {{' ',' ','*',' ',' '}, {' ', '*', ' ','*', ' '}, {'*','*','*','*','*'}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		

		map = new char[N][N*2-1];

		for(int i=0; i<N; i++){
			for(int j=0; j<2 * N -1; j++){
				map[i][j] = ' ';
			}
		}

		solve(0, 0, N);

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N; i++){
			for(int j=0; j<2 * N -1; j++){
				sb.append(map[i][j] + "");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
			
	}
	
	static void solve(int r, int c, int n){
		if(n == 3){

			for(int i=0; i<3; i++){
				for(int j=0; j<5; j++){
					map[i + r][j + c] = basis[i][j];
				}
			}
		/*	map[r][c] = '*';

			map[r + 1][c - 1] = '*';
			map[r + 1][c + 1] = '*';

			map[r + 2][c - 2] = '*';
			map[r + 2][c - 1] = '*';
			map[r + 2][c] = '*';
			map[r + 2][c + 1] = '*';
			map[r + 2][c + 2] = '*';*/
			return;
		}

		// n 은 2등분씩.. 세로는 2등분 해야함.. 분할해보면 답 나옴.

		solve(r, c + n / 2 , n / 2);
		solve(r + n / 2, c , n / 2);
		solve(r + n / 2, c + n , n / 2);
		
	}

}