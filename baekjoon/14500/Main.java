import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static BufferedReader br;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int max;

	public static void main(String[] args) throws Exception {

			br = new BufferedReader(new InputStreamReader(System.in));
			String[] str = br.readLine().split(" ");

			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);

			arr = new int[N][M];
			visited = new boolean[N][M];

			max = 0;

			for (int i = 0; i < N; i++) {
					str = br.readLine().split(" ");
					for (int j = 0; j < M; j++) {
							arr[i][j] = Integer.parseInt(str[j]);
					}
			}

			for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {

							DFS(i, j, 0, 0);
							solve(i, j);

					}
			}
			System.out.println(max);
	}

	public static void DFS(int x, int y, int depth, int sum) {

			if (depth == 4) {
					max = Math.max(max, sum);
					return;
			}

			for (int i = 0; i < 4; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
							continue;
					}
					if (visited[nextX][nextY]) {
							continue;
					}
					visited[nextX][nextY] = true;
					DFS(nextX, nextY, depth + 1, sum + arr[nextX][nextY]);
					visited[nextX][nextY] = false;

			}

	}

	public static void solve(int x, int y) {
			int wing = 4;    
			int min = Integer.MAX_VALUE;
			int sum = arr[x][y];
			for (int i = 0; i < 4; i++) {
					int nextX = x + dx[i];
					int nextY = y + dy[i];

				
					if (wing <= 2)
							return;

					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
							wing--;
							continue;
					}
					min = Math.min(min, arr[nextX][nextY]);
					sum = sum + arr[nextX][nextY];
			}
	
			if (wing == 4) {
					sum = sum - min;
			}
			max = Math.max(max, sum);
	}
}
