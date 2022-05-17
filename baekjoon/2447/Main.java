import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static char[][] map;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				map[i][j] = ' ';
			}
		}

		solve(0,0,N);
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				sb.append(map[i][j]);				
			}
			sb.append("\n");
		}

		System.out.println(sb);

		
	}

	static void solve(int r, int c, int n){
		
		if(n == 1){
			map[r][c] = '*';
			return;
		}

		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(i ==1 && j == 1){
					continue;
				}
				int temp = n / 3;
				solve(r + temp * i, c + temp * j, temp);
			}
		}

		
	}
	
}