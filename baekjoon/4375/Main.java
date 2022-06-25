import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			String input = "";

			while((input = br.readLine()) != null){
				int N = Integer.parseInt(input);
				int prev = 0;

				for(int i=1; i<N*2; i++){
					prev = (prev * 10 + 1) % N;
					if(prev == 0){
						System.out.println(i);
						break;
					}
				}
			}
	}
}