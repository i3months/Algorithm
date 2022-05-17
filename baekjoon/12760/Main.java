import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n, m, i, j, mxcnt;

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int[] mx = new int[m];
		int[] cnt = new int[n];

		for (i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (i = 0; i < n; i++)
			Arrays.sort(arr[i]);

		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++)
				mx[j] = Math.max(mx[j], arr[i][j]);

		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++)
				if (mx[j] == arr[i][j])
					cnt[i]++;

		mxcnt = 0;

		for (i = 0; i < n; i++)
			mxcnt = Math.max(mxcnt, cnt[i]);

		for (i = 0; i < n; i++)
			if (mxcnt == cnt[i])
				sb.append((i + 1) + " ");
				
		System.out.println(sb);
	}
}