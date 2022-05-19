import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Jewel[] arr = new Jewel[N];

		for(int i=0; i<N; i++){
			st =  new StringTokenizer(br.readLine());
			arr[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[] bag = new int[K];

		for(int i=0; i<K; i++){
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		Arrays.sort(bag);

		long ans  = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int j = 0;
		// 바깥에 선언해서 보석 탐색에 중복이 발생하지 않음

		for(int i=0; i<K; i++){
			//pq.clear();

			while(j < N && arr[j].M <= bag[i]){
				pq.add(arr[j].V);
				j++;
			}
			// 일단 들어갈 수 있는거 다 넣고 생각

			if(!pq.isEmpty()){
				ans = ans + pq.poll();
			}
		}
		// 

		System.out.println(ans);

		

	}	
}	

class Jewel implements Comparable<Jewel>{
	int M;
	int V;

	Jewel(int a, int b){
		M = a;
		V = b;
	}

	public int compareTo(Jewel o2){
		if(M > o2.M){
			return 1;
		}else if(M < o2.M){
			return -1;			
		}else{
			return o2.V - V;
		}
	}
}