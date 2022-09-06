import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	static int N,M,T;
	static int[][] map;
	static int[][] visit;
	static Locate gram;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static int startToGram = INF;
	static int gramToFin = INF;
	static int startToFin = INF;


	static int min = INF;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visit = new int[N + 1][M + 1];		

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<M+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2){
					gram = new Locate(i,j);
				}
			}
		}

		bfs1(1,1);
		bfs2(gram.r, gram.c);
		bfs3(1,1);

		int cmp1 = gramToFin + startToGram - 2;
		int cmp2 = startToFin - 1;

		min = Math.min(cmp1, cmp2);

		System.out.println(min <= T ? min : "Fail");		
		

		
		
		
	}

	static void bfs3(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		visit = new int[N + 1][M + 1];	
		
		q.add(new Locate(r,c));
		visit[r][c] = 1;

		while(!q.isEmpty()){
			Locate cur = q.poll();

			if(cur.r == N && cur.c == M){
				startToFin = visit[cur.r][cur.c];
				return;
			}

			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				
				if(nextR >= N+1 || nextR <= 0 || nextC >= M+1 || nextC <= 0){
					continue;
				}

				if(visit[nextR][nextC] != 0){
					continue;
				}				

				if(map[nextR][nextC] == 1){
					continue;
				}

				visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
				q.add(new Locate(nextR, nextC));				
				
			}
			
		}
	}

	static void bfs2(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		visit = new int[N + 1][M + 1];	
		
		q.add(new Locate(r,c));
		visit[r][c] = 1;

		while(!q.isEmpty()){
			Locate cur = q.poll();

			if(cur.r == N && cur.c == M){
				gramToFin = visit[cur.r][cur.c];
				return;
			}

			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				
				if(nextR >= N+1 || nextR <= 0 || nextC >= M+1 || nextC <= 0){
					continue;
				}

				if(visit[nextR][nextC] != 0){
					continue;
				}				

				visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
				q.add(new Locate(nextR, nextC));				
				
			}
			
		}
	}



	static void bfs1(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		visit = new int[N + 1][M + 1];	
		
		q.add(new Locate(r,c));
		visit[r][c] = 1;

		while(!q.isEmpty()){
			Locate cur = q.poll();

			if(cur.r == gram.r && cur.c == gram.c){
				startToGram = visit[cur.r][cur.c];
				return;
			}

			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				
				if(nextR >= N+1 || nextR <= 0 || nextC >= M+1 || nextC <= 0){
					continue;
				}

				if(visit[nextR][nextC] != 0){
					continue;
				}

				if(map[nextR][nextC] == 1){
					continue;
				}

				visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
				q.add(new Locate(nextR, nextC));				
				
			}
			
		}
	}
}

class Locate{
	int r, c;

	Locate(int r, int c){
		this.r=r;
		this.c=c;
	}
}