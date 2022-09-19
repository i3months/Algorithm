import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder(); 
	static int[] dr = {1,0};
	static int[] dc = {0,1};
	static char[][] map;
	static int N;

	static int min = 987654321;
	static int max = -987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                            
		N = Integer.parseInt(br.readLine());

		map = new char[N+1][N+1];

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++){
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		dfs(1,1, map[1][1] - '0', map[1][1]);

		System.out.println(max + " " + min);

	}

	static void dfs(int r, int c, int num, char oper){
		int tmp = map[r][c] - '0';

		if(tmp >= 0 && tmp <= 5){
			if(oper == '+') num += tmp;
			if(oper == '-') num -= tmp;
			if(oper == '*') num *= tmp;
		}else{
			oper = map[r][c];
		}

		if(r == N && c == N){
			max = Math.max(num, max);
			min = Math.min(min, num);
			return;
		}

		for(int i=0; i<2; i++){
			int nextR = r + dr[i];
			int nextC = c + dc[i];

			if(nextR >= N+1 || nextR <= 0 || nextC >= N+1 || nextC <= 0){
				continue;
			}

			dfs(nextR, nextC, num, oper);
		}
		
	}
}