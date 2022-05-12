import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int map[][] = new int[5][5];

		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;

		finalloop: for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				int temp = Integer.parseInt(st.nextToken());

				loop1: for (int k = 0; k < 5; k++) {
					for (int l = 0; l < 5; l++) {
						if (map[k][l] == temp) {
							map[k][l] = -1;
							break loop1;
						}
					}
				}

				// bingo check

				int bingocnt = 0;

				// row check
				for (int k = 0; k < 5; k++) {
					int chk = 0;
					for (int l = 0; l < 5; l++) {
						if (map[k][l] == -1) {
							chk++;
						}
						if (chk == 5) {
							bingocnt++;
							if (bingocnt == 3) {
								System.out.println(cnt);
								break finalloop;
							}
						}
					}
				}

				// column check
				for (int k = 0; k < 5; k++) {
					int chk = 0;
					for (int l = 0; l < 5; l++) {
						if (map[l][k] == -1) {
							chk++;
						}
						if (chk == 5) {
							bingocnt++;
							if (bingocnt == 3) {
								System.out.println(cnt);
								break finalloop;
							}
						}
					}
				}

				// cross line

				if (map[0][0] == -1 && map[1][1] == -1 && map[2][2] == -1 && map[3][3] == -1 && map[4][4] == -1) {
					bingocnt++;
					if (bingocnt == 3) {
						System.out.println(cnt);
						break finalloop;
					}
				}

				if (map[0][4] == -1 && map[1][3] == -1 && map[2][2] == -1 && map[3][1] == -1 && map[4][0] == -1) {
					bingocnt++;
					if (bingocnt == 3) {
						System.out.println(cnt);
						break finalloop;
					}
				}

				//

			}
		}

	}
}