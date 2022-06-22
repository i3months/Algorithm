import java.util.*;
import java.io.*;
import java.math.*;
import java.security.Key;

public class Main {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());


			Keyboard[] arr = new Keyboard[M];

			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				arr[i] = new Keyboard(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st.nextToken());
			}

			Arrays.sort(arr);

			for(int i=0; i<M; i++){
				System.out.print(arr[i].c);
			}
			
			

	}
}

class Keyboard implements Comparable<Keyboard>{
	int a;
	int b;
	String c;

	Keyboard(int a, int b, String c){
		this.a = a;
		this.b = b;
		this.c = c;		
	}

	public int compareTo(Keyboard o2){
		if(b > o2.b){
			return 1;
		}else if(b < o2.b){
			return -1;
		}else{
			if(a > o2.a){
				return 1;
			}else{
				return -1;
			}
		}
	}

}