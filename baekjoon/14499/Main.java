import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static int[] dice = {0, 0, 0, 0, 0, 0};

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<M; j++){
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		} // 지도에 값 넣어주기

		StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");

		for(int i=0; i<k; i++){
			boolean check = false;
			switch(Integer.parseInt(st3.nextToken())){
				
				case 1:
				if(y < M-1){
					rotate(dice, 1);
					check = true;
					y++;
				}
				break;

				case 2:
				if(y > 0){
					rotate(dice, 2);
					check = true;
					y--;
				}
				break;

				case 3:
				if(x>0){
					rotate(dice, 3);
					check = true;
					x--;
				}
				break;

				case 4:
				if(x<N-1){
					rotate(dice, 4);
					check = true;
					x++;
					
				}
			}

			if(check){
				if(map[x][y] == 0){
					map[x][y] = dice[5];
				}else{
					dice[5] = map[x][y];
					map[x][y] = 0;
				}

				sb.append(dice[0]).append('\n');
			}


		}

		System.out.println(sb);


		

	}

	static void rotate(int[] dice, int dir){
		int[][] rotation = {{4,2,1,6,5,3}, {3,2,6,1,5,4}, {5,1,3,4,6,2}, {2,6,3,4,1,5}};
		 // 기본형 전개도에서 동서남북으로 회전할 시 나올 수 있는 경우의수를 계산함
		 // 이 때 주사위는 인덱스로 접근
		 // 0 번째는 동쪽 1 번째는 서쪽 2 번쨰는 북쪽 3 번째는 남쪽
		 
		 int[] temp = new int[6];

		 dir = dir -1; // 배열로 접근하니까 -1 해줌

		 for(int i=0; i<6; i++){
			 temp[rotation[dir][i]-1] = dice[i]; 
		 }
		 // 주사위에 있는 값들을 회전한 주사위의 인덱스에 넣어준다.

		 for(int i=0; i<6; i++){
			 dice[i] = temp[i];
		 }
		
		 // 인덱스에 넣어줬으니 다시 옮겨준다
		 
		 


		 
	}


}