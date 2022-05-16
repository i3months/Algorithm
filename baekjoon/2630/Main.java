import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int N;
	static int[] ans = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		StringTokenizer st;

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0,0,N);

		System.out.println(ans[0]);
		System.out.println(ans[1]);



	}

	static void solve(int r, int c, int size){

		if(check(r,c,size)){
			ans[map[r][c]]++;
			return;
		}

		
		int size2 = size / 2;

		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				solve(r + i * size2, c + j * size2, size2);
			}
		}

		return;
		

		
	}

	static boolean check(int r, int c, int size){

		for(int i = r; i< r+size; i++){
			for(int j=c; j<c+size; j++){
				if(map[i][j] != map[r][c]){
					return false;
				}
			}
		}


		return true;
	}
}