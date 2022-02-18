import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		if(b>a){
			long temp = a;
			a = b;
			b = temp;
		}
			
		
		
		long gcd = gcd(a,b);

		for(int i=0; i<gcd; i++){
			sb.append("1");
		}
		System.out.println(sb);


	
	} 
	static long gcd(long a, long b){
		while(b != 0){
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}