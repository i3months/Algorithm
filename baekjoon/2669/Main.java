import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] map = new int[101][101];


		int cnt = 0;

		for(int i=0; i<4; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			for(int j=b; j<d; j++){
				for(int k=a; k<c; k++){

					if(map[j][k] == 0){
						cnt++;
						map[j][k] = 1;
					}
								
				}
			}
		
			
		}

		System.out.println(cnt);

	}
}