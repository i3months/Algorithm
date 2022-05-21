import java.util.*;
import java.io.*;

public class Main {	
	static int N;
	static char[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N*2-1];

		for(int i=0; i<N; i++){
			for(int j=0; j<2 * N -1; j++){
				map[i][j] = ' ';
			}
		}

		solve(0, N-1, N);

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
			map[r][c] = '*';

			map[r + 1][c - 1] = '*';
			map[r + 1][c + 1] = '*';

			map[r + 2][c - 2] = '*';
			map[r + 2][c - 1] = '*';
			map[r + 2][c] = '*';
			map[r + 2][c + 1] = '*';
			map[r + 2][c + 2] = '*';
			return;
		}

		solve(r, c, n / 2);
    solve(r + n / 2, c - n / 2, n / 2);
    solve(r + n / 2, c + n / 2, n / 2);
		
	}

}