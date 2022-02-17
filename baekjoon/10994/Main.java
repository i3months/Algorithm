import java.util.*;
import java.io.*;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		arr = new char[397][397];

		int len = (4 * (N-1)) + 1;
		
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				arr[i][j] = ' ';
			}
		}
		star(N,0,0);

		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	static void star(int N, int x, int y){
		if(N == 1){
			arr[x][y] = '*';
			return; // 1이면 별 하나만 찍기
		}
		int len = 4 * (N-1) + 1;

		for(int i = y; i<y+len; i++){
			arr[x][i] = '*';
			arr[x + len -1][i] = '*';
		} // horizontal 별찍기

		for(int i = x; i<x + len; i++){
			arr[i][y] = '*';
			arr[i][y + len -1] = '*';
		} // vertical 별찍기

		star(N-1, x+2, y+2);
		return;
	} 
}