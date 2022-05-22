import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int T = Integer.parseInt(br.readLine());

		for(int i=0; i<T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][M];

			for(int j=0; j<N; j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++){
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;

			for(int j=0; j<M; j++){
				for(int k=0; k<N-1; k++){
					int tmp_cnt = 0;
					for(int l=k+1; l<N; l++){
						if(arr[k][j] != 1){
							break;
						}
						if(arr[l][j] == 0){
							tmp_cnt++;
						}
						if(l == N-1){
							cnt = tmp_cnt + cnt;
						}
						
					}
				}
			}

			System.out.println(cnt);


		}

	}

}