import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if(N-1 == 0 && M-1 == 0){
			System.out.print(1);
			return;
		}

		int[][] map = new int[N][M];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int[][] dist = new int[N][M];
		boolean[][][] visit = new boolean[2][N][M];
		
		Queue<Locate> q = new LinkedList<>();

		q.add(new Locate(0,0,0));

		while(!q.isEmpty()){
			Locate tmp = q.poll();

			int r = tmp.r;
			int c = tmp.c;
			int crush = tmp.crush;

			for(int i=0; i<4; i++){
				int nr = r + dr[i];
				int nc = c + dc[i];

				if(nr <= -1 || nr >= N || nc <= -1 || nc >= M){
					continue;
				}

				if(map[nr][nc] == 1){
					if(crush == 0 && !visit[1][nr][nc]){
						visit[crush][nr][nc] = true;
						dist[nr][nc] = dist[r][c] + 1;
						q.add(new Locate(nr,nc,1));
					}
				}

				if(map[nr][nc] == 0){
					if(!visit[crush][nr][nc]){
						visit[crush][nr][nc] = true;
						dist[nr][nc] = dist[r][c] + 1;
						q.add(new Locate(nr,nc,crush));
					}
				}

				if(nr == N-1 && nc == M-1){
					// System.out.println("");
					System.out.println(dist[nr][nc] + 1);
					return;
				}

				
				
			}
		}
		

		System.out.println(-1);
		
		
	}
}

class Locate{
	int r, c, crush;

	Locate(int a, int b, int d){
		r = a;
		c = b;
		crush = d;
	}
}