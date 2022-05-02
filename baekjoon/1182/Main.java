import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int S;
	static int ans;

	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(1, 0);

		if (S == 0) {
			ans--;
		}

		System.out.println(ans);

	}

	static void solve(int K, int cumulative) {
		
		if (K == N + 1) {
			if (cumulative == S) {
				ans++;
			}
		} else {
			solve(K + 1, cumulative + arr[K]);
			solve(K + 1, cumulative);
		}

	}

}