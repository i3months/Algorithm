import java.io.*;
import java.util.*;

public class Main {			

	static class User{
		int r, c, time;
	
		User(int r, int c){
			this.r = r;
			this.c = c;
		}
	
		User(int r, int c, int time){
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static char[][][] map = new char[9][9][10];
	static int[] dr = {0,-1,1,0,0,-1,1,-1,1};
	static int[] dc = {0,0,0,-1,1,1,-1,-1,1};
	static ArrayList<User> list = new ArrayList<>();
	static ArrayList<User> list2 = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
			
		for(int i=1; i<9; i++){
			for(int j=1; j<9; j++){
				for(int k=0; k<10; k++){
					map[i][j][k] = '.';
				}
			}
		}

		for(int i=1; i<9; i++){
			String str = br.readLine();
			for(int j=1; j<9; j++){
				map[i][j][0] = str.charAt(j - 1);
				if(map[i][j][0] == '#'){
					list.add(new User(i,j));
				}
			}
		}		
		
		for(int i=1; i<10; i++){

			if(i % 2 == 1){
				for(User k : list){
					int r = k.r;
					int c = k.c;
	
					if(r + 1 >= 9){
						continue;
					}else{
						map[r+1][c][i] = '#';
						list2.add(new User(r + 1, c));
					}
				}
				list.clear();
			}

			if(i % 2 == 0){
				for(User k : list2){
					int r = k.r;
					int c = k.c;
	
					if(r + 1 >= 9){
						continue;
					}else{
						map[r+1][c][i] = '#';
						list.add(new User(r + 1, c));
					}
				}
				list2.clear();
			}
		}

		// for(int k=0; k<11; k++){
		// 	for(int i=1; i<9; i++){
		// 		for(int j=1; j<9; j++){
		// 			System.out.print(map[i][j][k] + " ");
		// 		}
		// 		System.out.println();
		// 	}
		// 	System.out.println();
		// }

		Queue<User> q = new LinkedList<>();	

		q.add(new User(8,1,0));

		while(!q.isEmpty()){
			User cur = q.poll();

			if(cur.r == 1 && cur.c == 8){
				System.out.println(1);
				System.exit(0);
			}

			for(int i=0; i<9; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];
				int curTime = cur.time;
				int nextTime = curTime + 1;

				if(curTime >= 9){
					curTime = 9;
				}

				if(nextTime >= 9){
					nextTime = 9;
				}

				if(nextR >= 9 || nextR <= 0 || nextC >= 9 || nextC <= 0){
					continue;
				}

				if(map[nextR][nextC][curTime] == '#'){
					continue;
				}

				if(map[nextR][nextC][nextTime] == '#'){
					continue;
				}

				q.add(new User(nextR, nextC, cur.time + 1));
				
			}
		}

		System.out.println(0);
		

	}
}
