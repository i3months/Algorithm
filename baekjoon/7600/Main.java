import java.util.*;
import java.io.*;

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String str = br.readLine();
			if(str.equals("#")){
				break;
			}

			int[] arr = new int[27];

			for(int i=0; i<str.length(); i++){
				if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
					arr[str.charAt(i) - 'a']++;
				}	

				if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
					arr[str.charAt(i) - 'A']++;
				}	
			}

			int cnt = 0;

			for(int j=0; j<arr.length; j++){
				if(arr[j] != 0){
					cnt++;
				}	
			}

			System.out.println(cnt);

			


		}

	}
}