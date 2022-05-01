import java.util.*;
import java.io.*;

public class Main {

	static long arr_koong[] = new long[68];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Assignment> stack = new Stack<>();

		StringTokenizer st;

		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 0) {

			}

			if (cmd == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				stack.push(new Assignment(A, T));

			}
			if (!stack.isEmpty()) {
				stack.peek().time--;

				if (stack.peek().time == 0) {
					ans = ans + stack.peek().score;
					stack.pop();
				}
			}

		}

		System.out.println(ans);

	}
}

class Assignment {
	int score = 0;
	int time = 0;

	Assignment(int a, int b) {
		score = a;
		time = b;
	}
}