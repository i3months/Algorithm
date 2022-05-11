import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());				

		for (int k = 0; k < T; k++) {
			int N = Integer.parseInt(br.readLine());
			boolean[] arr = new boolean[N + 1];

			for (int i = 2; i < N + 1; i++) {
				int j = 1;
				while (true) {
					int temp = i * j;
					if (temp > N) {
						break;
					}
					arr[i * j] = !arr[i * j];
					j++;
				}

			}

			int cnt = 0;
			for (int i = 1; i < N + 1; i++) {
				if (arr[i] == false) {
					cnt++;
				}
			}

			System.out.println(cnt);

		}

	}
}