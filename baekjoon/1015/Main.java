import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Num[] B = new Num[N];
		int[] P = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++){
		 	B[i] = new Num(Integer.parseInt(st.nextToken()), i);			 
		}

		Arrays.sort(B);

		for(int i=0; i<N; i++){
			P[B[i].idx] = i;
		}

		for(int i=0; i<N; i++){
			System.out.println(P[i]);
		}

		

		


	}
}

class Num implements Comparable<Num>{
	int num;
	int idx;

	Num(int a, int b){
		num = a;
		idx = b;
	}

	public int compareTo(Num o2){
		if(num != o2.num){
			return num - o2.num;
		}

		return idx - o2.idx;
	}
}