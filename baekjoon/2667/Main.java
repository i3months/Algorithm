import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	// 격자를 탐색할 때 사용할 수 있는 테크닉. 
	// 이차원 배열 말고 1차원 배열 2개로 설정해도 ㅇㅋ. 스타일에 따라서..

	static ArrayList<Integer> complex = new ArrayList<>();;
	// 단지 탐색.
	static int complex_cnt;
	// 한 단지에 몇 개의 집이 있는지.

	static boolean[][] visit;
	// 이미 방문한곳인지 확인해야함.
	static String[] map;
	// 공백 없이 입력이 들어온다. 이럴때는 String배열을 사용하는것도 좋다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				

		N = Integer.parseInt(br.readLine());

		map = new String[N];

		for(int i=0; i<N; i++){
			map[i] = br.readLine();
		}

		visit = new boolean[N][N];		

		// end of input

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(!visit[i][j] && map[i].charAt(j) == '1'){
					complex_cnt = 0;
					dfs(i,j);
					complex.add(complex_cnt);
				}
			}
		}

		Collections.sort(complex);

		StringBuilder sb = new StringBuilder();

		sb.append(complex.size() + "\n");
		for(int a : complex){
			sb.append(a + "\n");
		}

		System.out.println(sb);


		
	}

	static void dfs(int row, int column){
		complex_cnt++;
		visit[row][column] = true;
		for(int k = 0; k<4; k++){
			int next_row = row + dir[k][0];
			int next_column = column + dir[k][1];
			// column파트가 1이면 column을 조작, 0이면 row를 조작.
			// 격자를 탐색할 때 매우 유용..
			
			if(next_row < 0 || next_column < 0 || next_row >= N || next_column >= N){
				continue; // 지도에서 이탈하면 안됨.
			}

			if(map[next_row].charAt(next_column) == '0'){
				continue; // 지도에서 0 이면 집이 없다는걸 의미 갈 수 없다.
			}

			if(visit[next_row][next_column]){
				continue; // 이미 방문했던 곳이면 다시 갈 필요가 없다.
			}

			dfs(next_row, next_column);
			// 재귀는 믿음으로.. 익숙해지기.. 
		}
	}
}