import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	static boolean[][] clean_check;
	static boolean chk = false;
	static int[] dr = {-1,0,1,0}; // 북 동 남 서
	static int[] dc = {0,1,0,-1}; // 북 동 남 서 
	static int cnt = 0;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		clean_check = new boolean[N][M];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r,c,d);

		System.out.println(cnt);
		

	}

	static void clean(int r, int c, int dir){
		if(map[r][c] == 0){
			map[r][c] = 2;
			cnt++;
		}

		boolean flag = false;
		int origin_dir = dir;

		for(int i=0; i<4; i++){
			int next_dir = (dir + 3) % 4;
			int next_r = r + dr[next_dir];
			int next_c = c + dc[next_dir];

			if(next_r>0 && next_c >0 && next_r < N && next_c < M){ // 가장자리는 청소할 수 없다.
				if(map[next_r][next_c] == 0){ // 청소하지 않은 공간일 시
					clean(next_r, next_c, next_dir);
					flag = true;
					break;
				}
			}

			dir = (dir + 3) % 4;
		}

		if(!flag){
			int next_dir = (origin_dir + 2) % 4;
			int back_r = r + dr[next_dir];
			int back_c = c + dc[next_dir];

			if(back_r > 0 && back_c > 0 && back_r < N && back_c < M){
				if(map[back_r][back_c] != 1){
					clean(back_r, back_c, origin_dir);
				}
			}
		}


	}
}