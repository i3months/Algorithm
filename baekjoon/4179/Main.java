import java.io.*;
import java.util.*;

public class Main {			
	static int R, C;
	static char[][] map;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine())		;

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visit = new boolean[R + 1][C + 1];
		Queue<Node> q = new LinkedList<>();		

		Node tmp = null;

		for(int i=1; i<R+1; i++){
			String str = br.readLine();
			for(int j=1; j<C+1; j++){
				map[i][j] = str.charAt(j - 1);
				if(map[i][j] == 'J'){
					tmp = new Node(i,j,0,0);
				}

				if(map[i][j] == 'F'){
					q.add(new Node(i,j,0,1));
				}
			}
		}		

		q.add(tmp);

		while(!q.isEmpty()){
			Node cur = q.poll();

			for(int i=0; i<4; i++){
				int nextR = cur.r + dr[i];
				int nextC = cur.c + dc[i];

				if(nextR >= R + 1 || nextR <= 0 || nextC >= C +1 || nextC <= 0){
					if(cur.type == 0){
						System.out.println(cur.time + 1);
						return;
					}

					continue;
				}

				if(map[nextR][nextC] == '#'){
					continue;
				}
				
				if(map[nextR][nextC] == 'F'){
					continue;
				}
				
				
				if(cur.type == 0){
					if(visit[nextR][nextC]){
						continue;
					}

					q.add(new Node(nextR, nextC, cur.time + 1, 0));
					visit[nextR][nextC] = true;
				}

				if(cur.type == 1){
					map[nextR][nextC] = 'F';
					q.add(new Node(nextR, nextC, 0, 1));
				}

			}
		}
		
		System.out.println("IMPOSSIBLE");
		
	}
}

class Node{
	int r, c, time, type;

	Node(int r, int c, int time, int type){
		this.r = r;
		this.c = c;
		this.time = time;
		this.type = type;
	}
}