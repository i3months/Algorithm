import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static int N;
	static int M;
	static int[] dr = {-1,0,1,0}; // 북 동 남 서
	static int[] dc = {0,1,0,-1}; // 북 동 남 서 	
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // N M 입력

		map = new char[N][M];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j =0; j<M; j++){
				map[i][j] = str.charAt(j);
			}
		} // map 채우기 

		st = new StringTokenizer(br.readLine(), " ");

		int PR = Integer.parseInt(st.nextToken()) -1;
		int PC = Integer.parseInt(st.nextToken()) -1;

		int[] ans_arr = new int[4]; // U R D L 순으로 정답을 담을거

		int dir = 0;

		for(int i=0; i<4; i++){
			cnt = 0;
			int r = PR;
			int c = PC;

			if(i == 0){
				dir = 0;
			}else if(i == 1){
				dir = 1;
			}else if(i == 2){
				dir = 2;
			}else if(i == 3){
				dir = 3;
			}

			while(true){
				cnt++;
				if(cnt>2500000){
					ans_arr[i] = 1000000000;
					break;
				}
				
					
				r = r + dr[dir];
				c = c + dc[dir];
				if(r == -1 || r == N || c == -1 || c == M || map[r][c]  == 'C'){
					ans_arr[i] = cnt;
					break;
				}

				if(map[r][c] == '.'){
					continue;
				}

				if(map[r][c] == '/'){
					if(dir == 0){
						dir = 1;
					}else if(dir == 1){
						dir = 0;
					}else if(dir == 2){
						dir = 3;
					}else if(dir == 3){
						dir = 2;
					}
					continue;
				}

				if(map[r][c] == '\\'){
					if(dir == 0){
						dir = 3;
					}else if(dir == 1){
						dir = 2;
					}else if(dir == 2){
						dir = 1;
					}else if(dir == 3){
						dir = 0;
					}
				}

			
				
				
			}
		}


		int max_idx = 0;
		int max = 0;
		
		for(int i=0; i<4; i++){
			if(ans_arr[i] > max){
				max = ans_arr[i];
				max_idx = i;
			}
		}

		char[] char_arr = {'U','R','D','L'};
		
		System.out.println(char_arr[max_idx]);
		if(max == 1000000000){
			System.out.println("Voyager");
		}else{
			System.out.println(max);
		}
		

	}
}