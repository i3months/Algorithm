import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Problem> list = new ArrayList<>();

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list);

		int[] arr = new int[200001];

		for(int i=0; i<N; i++){
			int a = list.get(i).day;
			int b = list.get(i).num;

			pq.add(b);
			if(a < pq.size()){
				pq.poll();
			}
		}

		long sum = 0;
		while(!pq.isEmpty()){
			sum = sum + pq.poll();
		}

		System.out.println(sum);

	}
}

class Problem implements Comparable<Problem>{
	int day;
	int num;

	Problem(int a, int b){
		day = a;
		num = b;
	}

	public int compareTo(Problem o2){
		if(day > o2.day){
			return 1;
		}else if(day < o2.day){
			return -1;
		}else{
			return o2.num - num;
		}
	}
}