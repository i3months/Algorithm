import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String str = br.readLine();
			int len = (int)Math.sqrt((int)str.length());

			String[][] arr = new String[len][len];
			
			for(int j =0; j<len; j++){
				for(int k=0; k<len ; k++){
					arr[j][k] = str.charAt(len * j + k) + "";
				}
			}

			arr = spin(arr, len);
			arr = spin(arr, len);
			arr = spin(arr, len);

			for(int j=0; j<len ;j++){
				for(int k=0; k<len; k++){
					System.out.print(arr[j][k]);
				}
			}
			System.out.println();
			
	
		}

		
		
	}

	static String[][] spin(String[][] tmp, int len){

		String temp[][] = new String[len][len];
		
		for(int i=0; i<len; i++){
			for(int j=0; j<len; j++){
				temp[i][j] = tmp[len - 1 - j][i];
			}
		}

		return temp;

	}
}