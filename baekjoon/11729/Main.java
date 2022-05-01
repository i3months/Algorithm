import java.util.*;
import java.io.*;
 
public class Main {
 
	static StringBuilder sb;
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
 
		sb.append((int)Math.pow(2, N) - 1).append('\n');
 
		Hanoi(N, 1, 2, 3);

		System.out.println(sb);
 
	}

 
	public static void Hanoi(int N, int from, int by, int to) {
		if (N == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
 
		Hanoi(N - 1, from, to, by);
    
		sb.append(from + " " + to + "\n");
    
		Hanoi(N - 1, by, from, to);
 
	}
}