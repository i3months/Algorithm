import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());

		Lecture[] arr = new Lecture[N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));			
		}

		Arrays.sort(arr);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(arr[0].fin);

		for(int i=1; i<N; i++){
			if(pq.peek() <= arr[i].start){
				int a = pq.poll();				
			}			
			pq.add(arr[i].fin);
		}

		System.out.println(pq.size());		
		
	}
}

class Lecture implements Comparable<Lecture>{
	int start;
	int fin;

	Lecture(int a, int b){
		start = a;
		fin = b;
	}

	public int compareTo(Lecture o2){
		if(start > o2.start){
			return 1;
		}else if(start < o2.start){
			return -1;

		}else if(start == o2.start){

			if(fin >= o2.fin){
				return 1;
			}else{
				return -1;
			}

		}
		return 1;

	}
}