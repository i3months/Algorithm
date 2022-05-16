import java.util.*;
import java.io.*;
 
public class Main {
	
	static int[][] map;	
	
	 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M;
		if(N == 2){
			M = 1;
		}else{
			M = 2;
		}
		map = new int[3][3];

		int cnt = 1;

		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				map[i][j] = cnt;
				cnt++;
			}
		}

		StringTokenizer st;		

		for(int i=0; i<9; i++){
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;

			if(i % 2 == 0){
				map[r][c] = 100;
			}

			if(i % 2 == 1){
				map[r][c] = 200;
			}

			if(check()){
				if(i % 2 == 0){
					System.out.println(N);
					break;
				}else{
					System.out.println(M);
					break;
				}
			}else{
				if(i == 8){
					System.out.println(0);
					break;
				}
			}
		}
		
		
	}

	static boolean check(){
		for(int i=0; i<3; i++){
			if(map[i][0] == map[i][1] && map[i][2] == map[i][1]){
				return true;
			}
		}

		for(int i=0; i<3; i++){
			if(map[0][i] == map[1][i] && map[1][i] == map[2][i]){
				return true;
			}
		}

		if(map[0][0] == map[1][1] && map[1][1] == map[2][2]){
			return true;
		}

		if(map[0][2] == map[1][1] && map[1][1] == map[2][0]){
			return true;
		}

		return false;
	}
}