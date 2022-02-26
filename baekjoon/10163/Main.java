import java.util.*;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[1002][1002];

		for(int i=1; i<N+1; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for(int j = 1002 - y - height; j<1002 - y; j++){
				for(int k = x; k<x+width; k++){
					map[j][k] = i;
				}
			}
		}

		for(int i = 1; i<N+1; i++){
			int area = 0;
			for(int j=0; j<1002; j++){
				for(int k=0; k<1002; k++){
					if(map[j][k] == i){
						area++;
					}
				}
			}
			sb.append(area).append('\n');
		}

		System.out.println(sb);
	}
}

		
