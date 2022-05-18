import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String str = br.readLine();

			int[] arr = new int[10];

			int len = str.length();

			String ans = "";

			int start = 0;

			for(int j=len-1; j> 0; j--){
				if(str.charAt(j) > str.charAt(j-1)){
					arr[str.charAt(j) - '0']++;
					arr[str.charAt(j-1) -'0']++;	
					ans = str.substring(0, j-1);
					start = str.charAt(j-1) - '0';	
					//System.out.println(start);							
					break;					
				}else{
					arr[str.charAt(j) - '0']++;
				}				
			}			

			if(ans.equals("")){
				System.out.println("BIGGEST");
				continue;
			}

			for(int j=start + 1; j<10; j++){
				if(arr[j] != 0){
					ans = ans + String.valueOf(j);
					arr[j]--;					
					break;
				}
			}

			for(int j=0; j<10; j++){
				for(int k=0; k<arr[j]; k++){
					ans = ans + String.valueOf(j);					
				}									
			}

			System.out.println(ans);


		}

	}
}