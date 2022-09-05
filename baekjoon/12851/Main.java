import java.io.*;
import java.util.*;

public class Main {	
	static int INF = 987654321;	
	
	static boolean[] visit = new boolean[300_001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[1000_000];

		
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(N, 0));

		int min = 100_000;

		while(!q.isEmpty()){
			Node cur = q.poll();
			
			visit[cur.locate] = true;			

			if(cur.locate == K){
				arr[cur.time]++;
				min = Math.min(min, cur.time);
			}

			if(cur.locate * 2  <= 100_000 && !visit[cur.locate * 2]){
				q.add(new Node(cur.locate * 2, cur.time + 1));
			}


			if(cur.locate -1 >= 0 && !visit[cur.locate - 1]){
				q.add(new Node(cur.locate -1, cur.time + 1));
			}

			if(cur.locate + 1 <= 100_000 && !visit[cur.locate + 1]){
				q.add(new Node(cur.locate + 1, cur.time + 1));
			}
			
			
		}

		System.out.println(min);
		System.out.println(arr[min]);
	}
}
class Node{
	int locate, time;

	Node(int a, int b){
		locate = a;
		time = b;
	}
}