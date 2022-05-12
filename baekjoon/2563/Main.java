import java.util.*;
import java.io.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int arr[][] = new int[101][101];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for(int j =b; j<b+10; j++){
				for(int k = a; k<a+10; k++){
					arr[j][k] = 1;
				}
			}
			
		}
		int cnt = 0;

		for(int i=1 ;i<101; i++){
			for(int j=1; j<101; j++){
				if(arr[i][j] == 1){
					cnt++;
				}	
			}
			
		}
		System.out.println(cnt);
	}
}