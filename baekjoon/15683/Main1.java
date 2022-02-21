import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;
	static int[][] map; // 사무실
	static int ret = 0; // 정답
	static int cctv_size = 0; // CCTV가 나오는 개수
	static Object[] cctv = new Object[8]; // CCTV가 나오는 수는 최대 8개
	
	static int[] rot_size = {4,2,4,4,1}; // CCTV번호별로 가능한 경우의 수를 배열로 저장

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int y=0; y<N; y++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");			
			for(int x=0; x<M; x++){
				map[y][x] = Integer.parseInt(st2.nextToken());

				if(map[y][x] != 0 && map[y][x] != 6){ // 입력받을 때 동시에 CCTV검사도 진행
					cctv[cctv_size] = new CCTV(y, x, map[y][x] -1);
					cctv_size++;
				}
			}
		}


		ret = 65;

		dfs(0); // 탐색은 0번째 CCTV부터 시작함
		
		System.out.println(ret);

		 
	}

	static class CCTV{
		int type = 0;
		int y = 0;
		int x = 0;

		CCTV(int y, int x, int type){
			this.y = y;
			this.x = x;
			this.type = type;
			
		}
	}

	static void dfs(int cctv_index){

		if(cctv_index == cctv_size){ // 탐색을 마치고 나면 정답 갱신
			int candi = 0;
			for(int y=0; y<N; y++){
				for(int x = 0; x<M; x++){
					if(map[y][x] == 0){
						candi++;
					}
				}
			}

				for(int i=0; i<N; i++){
					for(int j=0; j<M; j++){
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println("-----------------");


			if(ret>candi){
				ret = candi;
			}
			return;
		}

		int[][] backup = new int[N][M]; // 백트래킹을 위해 맵을 백업해야 함. 백업용 맵 생성
		
		CCTV temp = (CCTV)cctv[cctv_index]; 
		int type = temp.type;

		for(int dir = 0; dir < rot_size[type]; dir++){
			map_copy(backup, map); // 맵 백업

			if(type == 0){
				update(dir, (CCTV)cctv[cctv_index]);
			}else if(type == 1){
				update(dir, (CCTV)cctv[cctv_index]);
				update(dir+2, (CCTV)cctv[cctv_index]);
			}else if(type == 2){
				update(dir, (CCTV)cctv[cctv_index]);
				update(dir+1,(CCTV)cctv[cctv_index]);
			}else if(type == 3){
				update(dir,(CCTV)cctv[cctv_index]);
				update(dir+1,(CCTV)cctv[cctv_index]);
				update(dir+2,(CCTV)cctv[cctv_index]);
			}else if(type == 4){
				update(dir,(CCTV)cctv[cctv_index]);
				update(dir+1,(CCTV)cctv[cctv_index]);
				update(dir+2,(CCTV)cctv[cctv_index]);
				update(dir+3,(CCTV)cctv[cctv_index]);
			}

			dfs(cctv_index + 1);

			map_copy(map,backup);
		}

	}

	static void map_copy(int desc[][], int src[][]){ // 복사함수 백업에 쓰임
		for(int y = 0; y<N; y++){
			for(int x = 0; x<M; x++){
				desc[y][x] = src[y][x];
			}
		}
	}

	static void update(int dir, CCTV cctv){ // CCTV의 방향에 따라 감시되는곳을 표시함. 0은 → 1은 ↑ 2는 ← 3은 ↓ 방향
		dir = (dir % 4);
		
		if(dir == 0 ){
			for(int x = cctv.x + 1; x<M; x++){
				if(map[cctv.y][x] == 6){
					break;
				}else{
					map[cctv.y][x] = -1;
				}
			}
		}

		if(dir == 1){
			for(int y = cctv.y - 1; y>=0; y--){
				if(map[y][cctv.x] == 6){
					break;
				}else{
					map[y][cctv.x] = -1;
				}
			}
		}

		if(dir == 2){
			for(int x = cctv.x - 1; x>=M; x--){
				if(map[cctv.y][x] == 6){
					break;
				}else{
					map[cctv.y][x] = -1;
				}
			}
		}

		if(dir == 3){
			for(int y = cctv.y + 1; y<N; y++){
				if(map[y][cctv.x] == 6){
					break;
				}else{
					map[y][cctv.x] = -1;
				}
			}
		}
	}
}