import java.util.*;
import java.io.*;
import java.math.*;

public class Main {							

	static int N;
	static int[][] map;
	static int[][] dir = {{1,-1,0,0}, {0,0,1,-1}};
	static int[][] dist;

	static int target_R, target_C;
	static int shark_R, shark_C;	
	static int len = -1; 

	static int shark_S = 2;
	static int eat;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 9){
					shark_R = i;
					shark_C = j;
					map[i][j] = 0;
				}
			}
		}

		while(true){
			dist = new int[N][N];
			target_R = Integer.MAX_VALUE;
			target_C = Integer.MAX_VALUE;
			len = Integer.MAX_VALUE;

			bfs(shark_R, shark_C);

			if(target_R != Integer.MAX_VALUE && target_C != Integer.MAX_VALUE){
				eat++;
				map[target_R][target_C] = 0;
				shark_R = target_R;
				shark_C = target_C;
				cnt = cnt + dist[target_R][target_C];

				if(eat == shark_S){
					shark_S++;
					eat = 0;
				}
			}else{
				break;
			}

		}
		System.out.println(cnt);
			
	}

	static void bfs(int r, int c){
		Queue<Locate> q = new LinkedList<>();
		q.add(new Locate(r,c));

		while(!q.isEmpty()){
			Locate tmp = q.poll();

			for(int i=0; i<4; i++){
				int nr = tmp.r + dir[0][i];
				int nc = tmp.c + dir[1][i];

				if((nr > -1 && nr < N && nc > -1 && nc < N) && (map[nr][nc] <= shark_S) && (dist[nr][nc] == 0)){
					dist[nr][nc] = dist[tmp.r][tmp.c] + 1;

					if(map[nr][nc] != 0 && map[nr][nc] < shark_S){
						if(len > dist[nr][nc]){
							len = dist[nr][nc];
							target_R = nr;
							target_C = nc;
						}else if(len == dist[nr][nc]){ // 거리 같은게 많으면 위에있는거 우선, 그 다음은 왼쪽에있는거 우선..
							if(target_R == nr){
								if(target_C > nc){
									target_R = nr;
									target_C = nc;
								}
							}else if(target_R > nr){
								target_R = nr;
								target_C = nc;
							}
						}
					}
					q.add(new Locate(nr, nc));
				}
			}
		}
	}
}

class Locate{
	int r;
	int c;
	Locate(int a, int b){
		r = a;
		c = b;
	}
}