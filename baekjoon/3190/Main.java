import java.util.*;
import java.io.*;

public class Main {

	static int map[][];
	static int time = 0;

	static Queue<Direction> q;
	static Queue<Snake> snake_q;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int swap = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());

			map[row - 1][column - 1] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		q = new LinkedList<>();
		snake_q = new LinkedList<>();

		HashMap<Integer, Character> hm = new HashMap<>();

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());

			int turn = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);

			hm.put(turn, direction);
		}

		snake_q.add(new Snake(0, 0));

		int r = 0;
		int c = 0;

		///
	
		///

		while (true) {

			time++;

			int next_row = r + dc[swap];
			int next_column = c + dr[swap];

			if (next_row < 0 || next_column < 0 || next_row > N - 1 || next_column > N - 1) {
				
				break;
			}
			

			if (snake_q.contains(new Snake(next_row, next_column))) {////////////////////////////////
				
				break;
			}


			if (map[next_row][next_column] == 1) {
				map[next_row][next_column] = 0;
				snake_q.add(new Snake(next_row, next_column));

				

			} else {
				snake_q.add(new Snake(next_row, next_column));
				snake_q.poll();
			}

			if (hm.containsKey(time)) {
				char tmp = hm.get(time);

				if (tmp == 'D') {
					swap = swap + 1;
					if (swap == 4) {
						swap = 0;
					}
				}

				if (tmp == 'L') {
					swap = swap - 1;
					if (swap == -1) {
						swap = 3;
					}
				}

			}

			r = next_row;
			c = next_column;

		}

		System.out.println(time);

	} // end of main method

}

class Direction {
	int turn;
	char direction;

	Direction(int a, char b) {
		turn = a;
		direction = b;
	}
}

class Snake {
	int row1;
	int column1;

	Snake(int a, int b) {
		row1 = a;
		column1 = b;
	}

	@Override
	public boolean equals(Object temp){
		Snake o2 = (Snake) temp;

		if(row1 == o2.row1 && column1 == o2.column1){			
			return true;
		}else{			
			return false;
		}
	}

}