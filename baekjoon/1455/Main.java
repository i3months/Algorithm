import java.io.*;
import java.util.*;

public class Main {
	static int arr[][];
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));					

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int ans = 0;

		arr = new int[N][M];

		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++){
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for(int i = M - 1; i >= 0; i--) {
			for(int j = N - 1; j >= 0; j--) {
					if(arr[j][i] == 1) {
							reverse(j, i);							
							ans = ans +  1;
					}					
			}			
		}
		System.out.println(ans);
	}

	static void reverse(int x, int y) {
		for(int i = 0; i <= x; i++) {
				for(int j = 0; j <= y; j++) {
						if(arr[i][j] == 1){
								arr[i][j] = 0;
						}else{
								arr[i][j] = 1;
						}
				}
		}
}

}