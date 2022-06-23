import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			StringTokenizer st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[][] map = new int[r][c];

			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int idx = 0;

			for(int i=0; i<r; i++){
				if(i % 2 == 0){
					for(int j=0; j<c; j++){
						if(arr[idx] != 0){
							arr[idx]--;
							map[i][j] = (idx+1);
						}else{
							idx++;
							arr[idx]--;
							map[i][j] = idx+1;
						}
					}
				}else if(i % 2 == 1){
					for(int j=c-1; j>=0; j--){
						if(arr[idx] != 0){
							arr[idx]--;
							map[i][j] = (idx+1);
						}else{
							idx++;
							arr[idx]--;
							map[i][j] = idx+1;
						}
					}
				}
			}

			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			

	}
}