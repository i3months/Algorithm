import java.io.*;
import java.util.*;

public class Main {			
	static int INF = 987654321;
	static int N, M;
	static int[][] map;	
	static int[][] visit;
	static boolean[] visitVirus;
	static int fillCnt = 0;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	static ArrayList<Locate> virusAble = new ArrayList<>();
	static Locate[] virusArr;

	static int min = INF;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		virusArr = new Locate[M + 1];						

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 2){
					virusAble.add(new Locate(i, j));
				}
				
				if(map[i][j] == 0){
					fillCnt++;
				}
			}
		}

		visitVirus = new boolean[virusAble.size()];
		bt(1, 0);

		if(min == 0){
			System.out.println(0);
			return;
		}

		System.out.println(min == INF ? -1 : min-1);
		
	}

	static void bt(int depth, int start){
		if(depth == M + 1){	

			int tmpMax = 0;

			int[][] mapCopy = new int[N+1][N+1];
			visit = new int[N+1][N+1];
			Queue<Locate> q = new LinkedList<>();

			for(int i=1; i<N+1; i++){
				for(int j=1; j<N+1; j++){
					mapCopy[i][j] = map[i][j];
				}
			}

			for(int i=1; i<M+1; i++){
				mapCopy[virusArr[i].r][virusArr[i].c] = 3;
				visit[virusArr[i].r][virusArr[i].c] = 1;
				q.add(new Locate(virusArr[i].r, virusArr[i].c));
			}

			int cnt = 0;

			while(!q.isEmpty()){
				Locate cur = q.poll();

				//
				if(cnt == fillCnt){
					min = Math.min(min, tmpMax);
					break;
				}

				//
				// boolean flag = false;

				// for(int i=1; i<N+1; i++){
				// 	for(int j=1; j<N+1; j++){
				// 		if(map[i][j] != 1){
				// 			if(mapCopy[i][j] == 0){
				// 				flag = true;
				// 			}
				// 		}
				// 	}
				// }
	
				// if(!flag){
				// 	min = Math.min(min, tmpMax);		
				// 	break;
				// } 
				//

				for(int i=0; i<4; i++){
					int nextR = cur.r + dr[i];
					int nextC = cur.c + dc[i];

					if(nextR >= N+1 || nextR <= 0 || nextC >= N+1 || nextC <= 0){
						continue;
					}

					if(visit[nextR][nextC] != 0){
						continue;
					}

					if(mapCopy[nextR][nextC] == 1 || mapCopy[nextR][nextC] == 3){
						continue;
					}

					if(mapCopy[nextR][nextC] == 0){
						cnt++;
					}

					mapCopy[nextR][nextC] = 3;
					visit[nextR][nextC] = visit[cur.r][cur.c] + 1;
					tmpMax = Math.max(tmpMax, visit[nextR][nextC]);
					q.add(new Locate(nextR,nextC));
				}
			}
				

			// for(int i=1; i<M+1; i++){
			// 	System.out.println(virusArr[i].r + " " + virusArr[i].c);
			// }System.out.println();
			
			return;
		}

		for(int i=start; i<virusAble.size(); i++){
			if(!visitVirus[i]){

				visitVirus[i] = true;
				virusArr[depth] = virusAble.get(i);
				bt(depth + 1, i + 1);						
				visitVirus[i] = false;

			}
	
		}

		
	}
}

class Locate{
	int r,c;

	Locate(int r, int c){
		this.r = r;
		this.c = c;
	}
}