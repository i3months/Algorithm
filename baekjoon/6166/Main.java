import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			while(true){
				int N = Integer.parseInt(br.readLine());

				if(N == 0){
					break;
				}

				String str = br.readLine();
				str = str.toUpperCase();
				str = str.replace(" ", "");
				
				char[] arr = new char[str.length()];

				int idx = 0;

				for(int i=0; i<N; i++){
					for(int j = i; j<str.length(); j = j + N){
						arr[j] = str.charAt(idx);
						idx++;								
					}					
				}

				for(int i=0; i<str.length(); i++){
					System.out.print(arr[i]);
				}
				System.out.println();
			}
	}
}