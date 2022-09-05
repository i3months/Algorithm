import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	static char[][] map;
	static int[][] mapCnt;
	static int ans = 0;

	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};

	static int R,C,N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		mapCnt = new int[R + 1][C + 1];

		for(int i=1; i<R+1; i++){
			for(int j=1; j<C+1; j++){
				mapCnt[i][j] = -1;
			}
		}

		for(int i=1; i<R+1; i++){
			String str = br.readLine();
			for(int j=1; j<C+1; j++){
				map[i][j] = str.charAt(j - 1);

				if(map[i][j] == 'O'){
					mapCnt[i][j] = 0;
				}

			}
		}

		for(int i = 2; i<N + 1; i++){

			if(i % 2 == 0){
				for(int j=1; j<R+1; j++){
					for(int k=1; k<C+1; k++){
						if(mapCnt[j][k] == -1){
							mapCnt[j][k] = i;
							map[j][k] = 'O'; 
						}
					}
				}
			}

			ArrayList<Locate> list = new ArrayList<>();

			if(i % 2 == 1){
				for(int j=1; j<R+1; j++){
					for(int k=1; k<C+1; k++){
						
						if(mapCnt[j][k] + 3 == i && mapCnt[j][k] != -1){
							for(int a = 0; a<5; a++){
								int nextR = j + dr[a];
								int nextC = k + dc[a];

								if(nextR >= R + 1 || nextR <= 0 || nextC >= C + 1 || nextC <= 0){
									continue;
								}						
								
								list.add(new Locate(nextR, nextC));

								// mapCnt[nextR][nextC] = -1;
								// map[nextR][nextC] = '.';

							}
						}
					}
				}
			}

			for(Locate k : list){
				map[k.r][k.c] = '.';
				mapCnt[k.r][k.c] = -1;
 			}
		}

		
		for(int i=1; i<R+1; i++){
			for(int j=1; j<C+1; j++){
				System.out.print(map[i][j] + "");
			}
			System.out.println();
		}
				
		
	}
	
}

class Locate{
	int r,c;
	Locate(int r, int c){
		this.r=r;
		this.c=c;

	}
}