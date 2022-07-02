import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());
			
		P[][] arr = new P[N][N];
		char[][] map = new char[N][N];

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				arr[i][j] = new P();
			}
		}

		String cmd = br.readLine();

		int r = 0, c = 0;

		for(int i=0; i<cmd.length(); i++){
			char tmp = cmd.charAt(i);

			if(tmp == 'U'){
				int nr = r + dr[1];
				int nc = c + dc[1];

				if(nr >= N || nr <= -1 || nc >= N || nc <= -1){
					continue;
				}

				arr[r][c].sj = true;
				arr[nr][nc].sj = true;

				r = nr;
				c = nc;
				
			}

			if(tmp == 'D'){
				int nr = r + dr[0];
				int nc = c + dc[0];

				if(nr >= N || nr <= -1 || nc >= N || nc <= -1){
					continue;
				}

				arr[r][c].sj = true;
				arr[nr][nc].sj = true;

				r = nr;
				c = nc;

			}

			if(tmp == 'R'){
				int nr = r + dr[2];
				int nc = c + dc[2];

				if(nr >= N || nr <= -1 || nc >= N || nc <= -1){
					continue;
				}

				arr[r][c].sp = true;
				arr[nr][nc].sp = true;

				r = nr;
				c = nc;
			}

			if(tmp == 'L'){
				int nr = r + dr[3];
				int nc = c + dc[3];

				if(nr >= N || nr <= -1 || nc >= N || nc <= -1){
					continue;
				}

				arr[r][c].sp = true;
				arr[nr][nc].sp = true;

				r = nr;
				c = nc;
			}
			 
			//System.out.println(r + " " + c);
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(arr[i][j].sj && arr[i][j].sp){
					map[i][j] = '+';
				}

				if(arr[i][j].sj && !arr[i][j].sp){
					map[i][j] = '|';
				}

				if(!arr[i][j].sj && arr[i][j].sp){
					map[i][j] = '-';
				}

				if(!arr[i][j].sj && !arr[i][j].sp){
					map[i][j] = '.';
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
			
	}		
}

class P{
	boolean sj, sp = false;		
}