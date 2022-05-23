import java.util.*;
import java.io.*;

public class Main {	

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[10001];
		PriorityQueue<Lecture> pq = new PriorityQueue<>();

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());				
			pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		for(int i=0; i<N; i++){
			Lecture tmp = pq.poll();
			
			for(int j= tmp.day; j>0; j--){
				if(arr[j] == 0){
					arr[j] = tmp.pay;
					break;
				}
			}			

		}



		int sum = 0;
		for(int i=0; i<10001; i++){
			sum = sum + arr[i];
		}

		System.out.println(sum);

		
		

	}
}

class Lecture implements Comparable<Lecture>{
	int pay;
	int day;

	Lecture(int a, int b){
		pay = a;
		day = b;
	}

	public int compareTo(Lecture o2){
		if(pay > o2.pay){
			return -1;
		}else{
			return 1;
		}
	}
}