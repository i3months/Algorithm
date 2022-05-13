import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				

		int N = Integer.parseInt(br.readLine());

		candidate arr[] = new candidate[N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new candidate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
	
		Arrays.sort(arr);

		int[] cnt = new int[100000];

		cnt[arr[0].nation]++;
		cnt[arr[1].nation]++;

		StringBuilder sb = new StringBuilder();

		sb.append(arr[0].nation + " " + arr[0].num + "\n");
		sb.append(arr[1].nation + " " + arr[1].num + "\n");

		for(int i=2; i<1000; i++){
			if(cnt[arr[i].nation] < 2){
				sb.append(arr[i].nation + " " + arr[i].num + "");
				break;
			}
		}
		
		System.out.println(sb);

		//System.out.println(arr[0].nation + " " + arr[0].num + " " + arr[0].score);

	}
}

class candidate implements Comparable<candidate>{
	int nation;
	int num;
	int score;

	candidate(int a, int b, int c){
		nation = a;
		num = b;
		score = c;
	}

	public int compareTo(candidate o2){
		if(score > o2.score){
			return -1;
		}else{
			return 1;
		}
	}
}