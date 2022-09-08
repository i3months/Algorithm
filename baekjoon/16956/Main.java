import java.io.*;
import java.util.*;

public class Main {			
	static int R, C;
	static char[][] map;
	static boolean[][] visit;

	static int max = -1;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		Queue<Locate> q = new LinkedList<>();

		for(int i=1; i<R+1; i++){
			String str = br.readLine();
			for(int j=1; j<C+1; j++){
				map[i][j] = str.charAt(j - 1);

				if(map[i][j] == 'W'){
					q.add(new Locate(i,j));
				}
			}
		}

		while(!q.isEmpty()){
			Locate cur = q.poll();

			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];

				if(nextR >= R+1 || nextR <= 0 || nextC >= C+1 || nextC <= 0) continue;

				if(map[nextR][nextC] == 'W'){
					continue;
				}

				if(map[nextR][nextC] == '.'){
					map[nextR][nextC] = 'D';
				}

				if(map[nextR][nextC] == 'S'){
					System.out.println(0);
					return;
				}
			}
		}

		System.out.println(1);
		for(int i=1; i<R+1; i++){
			for(int j=1 ;j<C+1; j++){
				System.out.print(map[i][j]);				
			}
			System.out.println();
		}
		

		

	}
}

class Locate{
	int r, c;
	Locate(int r, int c){
		this.r = r;
		this.c = c;
	}
}