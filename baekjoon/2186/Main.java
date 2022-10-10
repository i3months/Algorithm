import java.util.*;
import java.io.*;
import java.math.*;

class Main {
	static int INF = 987654321;
	static int N, M, K;
	static char[][] map;
	static int[][][] dp;
	static String target;
	static int len;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N + 1][M + 1];
		dp = new int[N + 1][M + 1][81];

		for(int i=1; i<N+1; i++){
			String tmp = br.readLine();
			for(int j=1; j<M+1; j++){
				map[i][j] = tmp.charAt(j - 1);
			}
		}

		target = br.readLine();
		len = target.length();

		for(int i=0; i<N+1; i++){
			for(int j=0; j<M+1; j++){
				for(int k=0; k<81; k++){
					dp[i][j][k] = -1;
				}
			}
		}


		int ans = 0;

		for(int i=1; i<N+1; i++){
			for(int j=1; j<M+1; j++){
				if(map[i][j] == target.charAt(0)){
					ans += dfs(i,j,1);
				}
			}
		}

		System.out.println(ans);
		

	}

	static int dfs(int r, int c, int idx){
		if(dp[r][c][idx] != -1) return dp[r][c][idx];
		if(idx >= len) return 1;
		
		dp[r][c][idx] = 0;

		for(int i=0; i<4; i++){
			for(int j=1; j<K+1; j++){
				
				int nextR = r + (dr[i] * j);
				int nextC = c + (dc[i] * j);

				if(nextR >= N+1 || nextR <= 0 || nextC >= M+1 || nextC <= 0) continue;
				if(map[nextR][nextC] != target.charAt(idx)) continue;

				dp[r][c][idx] += dfs(nextR, nextC, idx + 1);
			}
		}

		return dp[r][c][idx];
		
	}
}