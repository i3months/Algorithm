import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = new int[2];
		for(int i=0; i<2; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0; 
			for(int j=0; j<4; j++){
				sum = sum + Integer.parseInt(st.nextToken());
			}
			arr[i] = sum;
		}

		if(arr[0]>arr[1]){
			System.out.println(arr[0]);
		}else{
			System.out.println(arr[1]);
		}

	}
}