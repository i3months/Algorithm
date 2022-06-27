import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	
	static int N;
	static char[][] map;
	static boolean visit[][];

	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];

		for(int i=0; i<N; i++){
			String tmp = br.readLine();
			for(int j=0; j<N; j++){
				map[i][j] = tmp.charAt(j);
			}
		}

		int cnt1 = 0;
		visit = new boolean[N][N];

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!visit[i][j]){
					cnt1++;
					visit[i][j] = true;

					bfs(i,j);
				}
			}
		}

		int cnt2 = 0;
		visit = new boolean[N][N];

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!visit[i][j]){
					cnt2++;
					visit[i][j] = true;

					bfs2(i,j);
				}
			}
		}

		System.out.println(cnt1 + " " + cnt2);

	}

	static void bfs2(int a, int b){
		Queue<Locate> q = new LinkedList<>();
		q.add(new Locate(a,b));
		
		char symbol = map[a][b];

		while(!q.isEmpty()){
			Locate tmp = q.poll();

			for(int i=0; i<4; i++){
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N){
					continue;
				}

				if(symbol == 'R' || symbol == 'G'){
					if(('R' == map[nr][nc] || 'G' == map[nr][nc]) && !visit[nr][nc]){
						visit[nr][nc] = true;
						q.add(new Locate(nr, nc));
					}
				}else{
					if(symbol == map[nr][nc] && !visit[nr][nc]){
						visit[nr][nc] = true;
						q.add(new Locate(nr, nc));
					}
				}
				
				
			}
		}
	}


	static void bfs(int a, int b){
		Queue<Locate> q = new LinkedList<>();
		q.add(new Locate(a,b));
		
		char symbol = map[a][b];

		while(!q.isEmpty()){
			Locate tmp = q.poll();

			for(int i=0; i<4; i++){
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];

				if(nr < 0 || nr >= N || nc < 0 || nc >= N){
					continue;
				}

				if(symbol == map[nr][nc] && !visit[nr][nc]){
					visit[nr][nc] = true;
					q.add(new Locate(nr, nc));
				}
				
			}
		}
	}
	
}

class Locate{
	int r,c;
	Locate(int a, int b){
		r = a;
		c = b;
	}
}