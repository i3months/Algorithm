import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int TC, N, M;
	static char[][] map;
	static int[][] visit;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int TC = Integer.parseInt(br.readLine());

		while(TC-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			map = new char[N + 1][M + 1];
			visit = new int[N + 1][M + 1];
			Locate user = null;

			Queue<Locate> q = new LinkedList<>();

			for(int i=1; i<N+1; i++){
				String str = br.readLine();
				for(int j=1; j<M+1; j++){
					map[i][j] = str.charAt(j - 1);

					if(map[i][j] == '@'){
						user = new Locate(i,j,1);
					}

					if(map[i][j] == '*'){
						q.add(new Locate(i,j,0));
					}

				}
			}

			q.add(user);
			visit[user.r][user.c] = 1;

			int ans = -1;

			loop1 : while(!q.isEmpty()){
				Locate cur = q.poll();

				for(int i=0; i<4; i++){
					int nextR = cur.r + dr[i];
					int nextC = cur.c + dc[i];

					if(nextR >= N + 1 || nextR <= 0 || nextC >= M + 1 || nextC <= 0){
						if(cur.type == 1){
							ans = visit[cur.r][cur.c];							
							break loop1;
						}
						continue;
					}

					if(map[nextR][nextC] == '#'){
						continue;
					}

					if(cur.type == 1 && visit[nextR][nextC] != 0){
						continue;
					}

					if(map[nextR][nextC] == '*'){
						continue;
					}

					if(cur.type == 0){
						map[nextR][nextC] = '*';
						q.add(new Locate(nextR, nextC, 0));
					}

					if(cur.type == 1){
						visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
						q.add(new Locate(nextR, nextC, 1));
					}

					
				}
			}

			sb.append(ans == -1 ? "IMPOSSIBLE\n" : ans + "\n");
			
			
		}

		System.out.println(sb);
				

		

		
	}
}

class Locate{
	int r, c, type;
	Locate(int r, int c, int type){
		this.r = r;
		this.c = c;
		this.type = type;
	}
}