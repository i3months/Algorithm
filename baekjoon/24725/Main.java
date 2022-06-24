import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				

	static int R, C;	

	static int[] dr = {1,0,1,0};
	static int[] dc = {0,1,0,1};
	static char[][] map;

	static int cnt = 0;	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			for(int i=0; i<R; i++){
				String tmp = br.readLine();
				for(int j=0; j<C; j++){
					map[i][j] = tmp.charAt(j);
				}
			}

			for(int i=0; i<R; i++){
				for(int j=0; j<C; j++){
					if(map[i][j] == 'E' || map[i][j] == 'I'){						
						right(i,j);
						left(i,j);
						down(i,j);
						up(i,j);
						one(i,j);
						two(i,j);
						three(i,j);
						four(i,j);
					}
				}
			}

			System.out.println(cnt);

			
	}

	static void right(int r, int c){
		c++;		
		if(c >= C || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c++;
		if(c >= C || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c++;
		if(c >= C || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}		
		
		cnt++;
		return;
	}

	static void left(int r, int c){
		c--;
		if(c <= -1 || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c--;
		if(c <= -1 || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c--;
		if(c <= -1 || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}
		
		cnt++;
		return;				
	}

	static void up(int r, int c){
		r--;
		if(r <= -1 || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		r--;
		if(r <= -1 || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		r--;
		if(r <= -1 || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}

		cnt++;
		return;
	}

	static void down(int r, int c){
		r++;		

		if(r >= R){			
			return;
		}
		if(map[r][c] != 'N' && map[r][c] != 'S'){			
			return;
		}		
		r++;
		if(r >= R || map[r][c] != 'F' && map[r][c] != 'T'){
			return;
		}
		r++;
		if(r >= R || map[r][c] != 'P' && map[r][c] != 'J'){
			return;
		}		
		cnt++;
		return;
	}

	static void one(int r, int c){
		c++;
		r--;
		if(c >= C || r <= -1 || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c++;
		r--;
		if(c >= C || r <= -1 || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c++;
		r--;
		if(c >= C || r <= -1 || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}

		cnt++;
		return;
	}

	static void two(int r, int c){
		c++;
		r++;
		if(c >= C || r>= R || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c++;
		r++;
		if(c >= C || r>= R || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c++;
		r++;
		if(c >= C || r>= R || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}
		cnt++;
		return;
	}

	static void three(int r, int c){
		c--;
		r++;
		if(c <= -1 || r>= R || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c--;
		r++;
		if(c <= -1 || r>= R || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c--;
		r++;
		if(c <= -1 || r>= R || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}

		cnt++;
		return;
	}

	static void four(int r, int c){
		c--;
		r--;
		if(c <= -1 || r<= -1 || (map[r][c] != 'N' && map[r][c] != 'S')){
			return;
		}
		c--;
		r--;
		if(c <= -1 || r<= -1 || (map[r][c] != 'F' && map[r][c] != 'T')){
			return;
		}
		c--;
		r--;
		if(c <= -1 || r<= -1 || (map[r][c] != 'P' && map[r][c] != 'J')){
			return;
		}
		cnt++;
	return;
	}	
}