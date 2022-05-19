import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			String[] str = br.readLine().split(" ");

			if(str[0].equals("Simon") && str[1].equals("says")){
				System.out.print(" ");
				for(int j=2; j<str.length; j++){
					System.out.print(str[j] + " ");
				}
				System.out.println();
			}
			
			
		}


	}
}