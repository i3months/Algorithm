import java.util.*;
import java.io.*;
 
public class Main {
 
	static StringBuilder sb;
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());

		int cnt = 0;

		for(int i=1; i<500; i++){
			for(int j=i+1; j<500+1; j++){				
				if(j * j  == i*i + N){
					cnt++;
				}
			}
		}

		System.out.println(cnt);
 
	}
}