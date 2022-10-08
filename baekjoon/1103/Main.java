import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int INF = 987654321;

	static int N;
	static int M;
	static int[][] map;	
	static int[][] dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N][M];
		dp = new int[N][M];
		map = new int[N][M];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				if(str.charAt(j) == 'H') map[i][j] = 0;
				else map[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(dfs(0,0));
		
		
	}

	static int dfs(int r, int c){		
		if(r >= N || r <= -1) return 0;
		if(c >= M || c <= -1) return 0;
		if(map[r][c] == 0) return 0;

		if(visit[r][c]){
			System.out.println(-1);
			System.exit(0);
		}


		if(dp[r][c] != 0) return dp[r][c];

		visit[r][c] = true;
		dp[r][c] = -INF;

		for(int i=0; i<4; i++){
			int nextR = r + (dr[i] * map[r][c]);
			int nextC = c + (dc[i] * map[r][c]);

			dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC) + 1);
		}
		visit[r][c] = false;
		

		return dp[r][c];
	}
}