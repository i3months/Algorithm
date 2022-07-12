import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		long[][] arr = new long[N+1][N+1];

		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++){
				if(i == j){
					arr[i][j] = 0;
				}else{
					arr[i][j] = Integer.MAX_VALUE;
				}				
			}
		}

		for(int i=0; i<M; i++){
			StringTokenizer st=  new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			arr[A][B] = Math.min(arr[A][B], C);
		}

		// //
		// for(int i=1; i<N+1; i++){
		// 	for(int j=1; j<N+1; j++){
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		// //

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {							
							if (arr[i][j] > arr[i][k] + arr[k][j]) {
									arr[i][j] = arr[i][k] + arr[k][j];
							}
					}
			}
	}

		//
		// for(int i=1; i<N+1; i++){
		// 	for(int j=1; j<N+1; j++){
		// 		System.out.print(arr[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		//

	StringBuilder sb = new StringBuilder();

	for(int i=1; i<N+1; i++){
		for(int j=1; j<N+1; j++){
			if(arr[i][j] == Integer.MAX_VALUE){
				sb.append("0" + " ");
			}else{
				sb.append(arr[i][j] + " ");
			}
		}
		sb.append("\n");
	}

	System.out.println(sb);

	


	}
}