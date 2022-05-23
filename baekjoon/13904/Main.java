import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Assignment> pq = new PriorityQueue<>();

		StringTokenizer st;

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			pq.add(new Assignment(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));			
		}

		int[] ans = new int[1001];

		for(int i=0; i<N; i++){
			Assignment tmp = pq.poll();
			for(int j = tmp.left; j>0; j--){
				if(ans[j] == 0){
					ans[j] = tmp.score;
					break;
				}
			}
		}

		int sum = 0;

		for(int i=0; i<1001; i++){
			sum = sum + ans[i];
		}

		System.out.println(sum);

	}
}

class Assignment implements Comparable<Assignment>{
	int left;
	int score;

	Assignment(int a, int b){
		left = a;
		score = b;
	}

	public int compareTo(Assignment o2){
		if(score > o2.score){
			return -1;
		}else{
			return 1;
		}
	}
}