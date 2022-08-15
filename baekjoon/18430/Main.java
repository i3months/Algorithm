import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, M;
    static int[][] map;    

    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt(0,0, new boolean[N][M], 0);

        System.out.println(ans);

        

    }

    static void bt(int r, int c, boolean visit[][], int sum){
        if(r == N - 1){
            ans = Math.max(ans, sum);
            return;
        }

        boolean visited[][] = new boolean[N][M];

        for(int i=0; i<5; i++){

            for(int j=0; j<N; j++){
                visited[j] = Arrays.copyOf(visit[j], M);
            }

            int val = placement(i, r, c, visited);
            
            if(val != -1){
                // int nextC = (c + 1 == M - 1) ? 0 : c + 1;
                // int nextR = (nextC == M - 1) ? r + 1 : r;

                int nextC=c+1==M-1?0:c+1;
				int nextR=c+1==M-1?r+1:r;

                bt(nextR, nextC, visited, sum + val);
            }

        }

        
        
    }

    static int placement(int type, int r, int c, boolean visit[][]) {
		if (type == 0) {
			if (!visit[r][c] && !visit[r][c + 1] && !visit[r + 1][c + 1]) {
				visit[r][c] = true;visit[r][c + 1] = true;visit[r + 1][c + 1] = true;
				return map[r][c]+(2*map[r][c+1])+map[r+1][c+1];
			} 
		} 
		else if (type == 1) {
			if (!visit[r][c + 1] && !visit[r + 1][c + 1] && !visit[r + 1][c]) {
				visit[r][c + 1] = true;visit[r + 1][c + 1] = true;visit[r + 1][c] = true;
				return map[r][c+1]+(2*map[r+1][c+1])+map[r+1][c];
			}
		}
		else if (type == 2) {
			if (!visit[r][c] && !visit[r + 1][c] && !visit[r + 1][c + 1]) {
				visit[r][c] = true;visit[r + 1][c] = true;visit[r + 1][c + 1] = true;
				return map[r][c]+(2*map[r+1][c])+map[r+1][c+1];
			}
		}
		else if (type == 3) {
				if (!visit[r][c] && !visit[r + 1][c] && !visit[r][c + 1]) {
					visit[r][c] = true;visit[r + 1][c] = true;visit[r][c + 1] = true;
					return (2*map[r][c])+map[r+1][c]+map[r][c+1];
				}
		} 
		else if (type == 4) {
				return 0;
			}
		return -1;
	}

    
}