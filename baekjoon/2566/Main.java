import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

		int[][] arr = new int[9][9];

		for(int i=0; i<9; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int x =0;
		int y =0;

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(arr[i][j] >= max){
					max = arr[i][j];
					x = j+1;
					y = i+1;
				}
			}
		}
		sb.append(max).append("\n");
		sb.append(x + " " + y);

		System.out.println(sb);


	}
}

		
