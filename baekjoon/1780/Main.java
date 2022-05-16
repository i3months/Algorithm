import java.util.*;
import java.io.*;
 
public class Main {

	static int N;
	static int[][] map;
	static int[] ans = new int[3];
	
	 	public static void main(String[] args) throws IOException{
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

		solve(0,0,N); // 0,0부터 탐색 시작. 처음 크기 N * N부터 시작해 3씩 나눠간다.

		for(int i=0; i<3; i++){
			System.out.println(ans[i]);
		}

		
		
	}
	
	static void solve(int a, int b, int c){
		if(check(a,b,c)){
			ans[map[a][b] + 1]++; // 같은 수로 이루어져있다면 ok. 그대로 함수 종료.
			return;
		}

		int temp = c / 3;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				solve(a + i * temp, b + j * temp, temp);
				// 이렇게 작성하면 모든 경우를 볼 수 있겠지?
				// 믿음이 필요.
			}
		}
		return; // 생략 ok 함수 끝에 오면 자동 return	
	}
	
	static boolean check(int r, int c, int n){
				
		for(int i=r; i<r+n; i++){
			for(int j=c; j<c+n; j++){
				if(map[r][c] != map[i][j]){
					return false;
				}
			}
		}

		return true;
	}
}