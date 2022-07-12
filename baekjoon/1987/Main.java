import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};

	static int R, C;

	static char[][] map;
	static boolean[] alpha = new boolean[27];

	static int ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for(int i=0; i<R; i++){
			String str = br.readLine();
			for(int j=0; j<C; j++){
				map[i][j] = str.charAt(j);
			}
		}	

		alpha[map[0][0] - 'A'] = true;
		
		dfs(0,0,1);
		
		System.out.println(ans);
		

	}

	static void dfs(int r, int c, int cnt){
		ans = Math.max(ans, cnt);

		for(int i=0; i<4; i++){
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr <= -1 || nr >= R || nc <= -1 || nc >= C){
				continue;
			}

			if(alpha[map[nr][nc] - 'A']){
				continue;
			}

			alpha[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, cnt + 1);
			alpha[map[nr][nc] - 'A'] = false;
			

		}
	}
}

class Locate{
	int r, c, cnt;

	Locate(int a, int b, int c){
		r = a;
		c = b;
		cnt = c;
	}
}