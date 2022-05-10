import java.util.*;
import java.io.*;

public class Main {
	static int[] ans;
	static int[] nums;
	static boolean[] visit;

	static int N;

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			N = Integer.parseInt(br.readLine());

			nums = new int[N];
			visit = new boolean[N];
			ans = new int[N];

			for (int i = 1; i < N+1; i++) {
					nums[i-1] = i;
			}

			backtracking(0);
	}

	static void backtracking(int depth) {

			if (depth == N) {
					for(int i=0; i<N; i++){
						System.out.print(ans[i] + " ");
					}

					System.out.println();
					return;
			}
			
			for (int i = 0; i < N; i++) {
					if (!visit[i]) {
							visit[i] = true;
							ans[depth] = nums[i];
							backtracking(depth + 1);
							visit[i] = false;
					}
			}
	}
}