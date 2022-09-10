import java.io.*;
import java.util.*;

public class Main {			
	static StringBuilder sb = new StringBuilder();

	static int N, K, S, R, C;
	static int[][] map;
	static boolean[][] visit;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		ArrayList<Locate> list = new ArrayList<>();

		for(int i=1; i<N+1; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0){
					list.add(new Locate(i, j, map[i][j], 0));
				}
			}
		}
        
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());		
        C = Integer.parseInt(st.nextToken());

		Collections.sort(list);

		Queue<Locate> q = new LinkedList<>();

		for(Locate k : list){
			q.add(new Locate(k.r, k.c, k.type, 0));
			visit[k.r][k.c] = true;
		}
		

		while(!q.isEmpty()){
			Locate cur = q.poll();

			if(cur.time == S){

			// 	System.out.println("print : ");

			// for(int i=1; i<N+1; i++){
			// 		for(int j=1; j<N+1 ;j++){
			// 		System.out.print(map[i][j] + " ");
			// 	}System.out.println();
			// }
			// System.out.println("print end");


				System.out.println(map[R][C]);
				return;
			}
			
			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];

				if(nextR >= N+1 || nextR <= 0 || nextC >= N+1 || nextC <= 0){
					continue;
				}

				if(visit[nextR][nextC]){
					continue;
				}
				
				if(map[nextR][nextC] != 0){
					continue;
				}

				map[nextR][nextC] = cur.type;
				visit[nextR][nextC] = true;
				q.add(new Locate(nextR, nextC, cur.type, cur.time + 1));
			}
		}

		System.out.println(map[R][C]);

		// System.out.println(map[R + 1][C + 1]);

		// for(int i=1; i<N+1; i++){
		// 	for(int j=1; j<N+1 ;j++){
		// 		System.out.print(map[i][j] + " ");
		// 	}System.out.println();
		// }
		
		
	}
}

class Locate implements Comparable<Locate>{
	int r, c, type, time;

	Locate(int r, int c, int type, int time){
		this.r = r;
		this.c = c;
		this.type = type;
		this.time = time;
	}

	public int compareTo(Locate o2){
		if(type > o2.type){
			return 1;
		}else{
			return -1;
		}
	}

}