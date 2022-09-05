import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	static int[][] map;
	static int ans = 0;

	static int[] odd_dr = {1,1,-1,-1,0,0};
	static int[] odd_dc = {1,0,1,0,1,-1};
	static int[] even_dr = {1,1,-1,-1,0,0};
	static int[] even_dc = {-1,0,-1,0,1,-1};
	static boolean[][] visit;

	static int R,C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		visit = new boolean[R + 1][C + 1];

		for(int i=1; i<R+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<C+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<R+1; i++){
			for(int j=1; j<C+1; j++){
				if(map[i][j] == 1 && !visit[i][j]){
					bfs1(i,j);
				}

				if(map[i][j] == 0 && !visit[i][j]){
					bfs2(i,j);
				} 				
			}
		}


		// bfs2(2,7);
		System.out.println(ans);		
		
		
	}

	static void bfs1(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		
		visit[r][c] = true;
		q.add(new Locate(r,c,0));

		while(!q.isEmpty()){
			Locate cur = q.poll();
			
			if(cur.r % 2 == 0){
				// 짝수
				for(int i=0; i<6; i++){
					int nextR = cur.r + even_dr[i];
					int nextC = cur.c + even_dc[i];

					if(nextR >= R+1 || nextR <= 0 || nextC >= C+1 || nextC <= 0){
						continue;
					}

					if(map[nextR][nextC] != 1){
						continue;
					}else{
						cur.adj++;
					}

					if(visit[nextR][nextC]){
						continue;
					}

					visit[nextR][nextC] = true;
					q.add(new Locate(nextR, nextC, 0));
					
				}
			}

			if(cur.r % 2 == 1){
				// 홀수
				for(int i=0; i<6; i++){
					int nextR = cur.r + odd_dr[i];
					int nextC = cur.c + odd_dc[i];

					if(nextR >= R+1 || nextR <= 0 || nextC >= C+1 || nextC <= 0){
						continue;
					}

					if(map[nextR][nextC] != 1){
						continue;
					}else{
						cur.adj++;
					}

					if(visit[nextR][nextC]){
						continue;
					}

					visit[nextR][nextC] = true;
					q.add(new Locate(nextR, nextC, 0));
					
				}
			}

			int sum = 6 - cur.adj;
			// System.out.println("r " + cur.r +" c " + cur.c + " adj " +cur.adj);

			ans += sum;
		}
	}


	static void bfs2(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		
		visit[r][c] = true;
		q.add(new Locate(r,c,0));

		boolean chk = false;
		int sum = 0;

		while(!q.isEmpty()){
			Locate cur = q.poll();
			
			if(cur.r % 2 == 0){
				// 짝수
				for(int i=0; i<6; i++){
					int nextR = cur.r + even_dr[i];
					int nextC = cur.c + even_dc[i];

					if(nextR >= R+1 || nextR <= 0 || nextC >= C+1 || nextC <= 0){
						chk = true;
						continue;
					}

					if(map[nextR][nextC] != 0){
						continue;
					}else{
						cur.adj++;
					}

					if(visit[nextR][nextC]){
						continue;
					}

					visit[nextR][nextC] = true;
					q.add(new Locate(nextR, nextC, 0));					
					
				}
			}

			if(cur.r % 2 == 1){
				// 홀수
				for(int i=0; i<6; i++){
					int nextR = cur.r + odd_dr[i];
					int nextC = cur.c + odd_dc[i];

					if(nextR >= R+1 || nextR <= 0 || nextC >= C+1 || nextC <= 0){
						chk = true;
						continue;
					}

					if(map[nextR][nextC] != 0){
						continue;
					}else{
						cur.adj++;
					}

					if(visit[nextR][nextC]){
						continue;
					}

					visit[nextR][nextC] = true;
					q.add(new Locate(nextR, nextC, 0));
					
				}
			}			
			
			sum += 6 - cur.adj;
		}

		if(!chk){
			ans -= sum;				
		}		
		
	}
}

class Locate{
	int r, c, adj;

	Locate(int r, int c, int adj){
		this.r = r;
		this.c = c;
		this.adj = adj;
	}
}