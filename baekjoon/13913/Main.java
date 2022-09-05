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
		
		int[] parent = new int[300_001];
		
		Queue<Node> q = new LinkedList<>();

		q.add(new Node(N, 0, String.valueOf(N)));

		int min = 100_000;		

		visit[N] = true;

		while(!q.isEmpty()){
			Node cur = q.poll();							

			if(cur.locate == K){				
				min = Math.min(min, cur.time);
				// if(min >= cur.time){
					min = cur.time;					
					break;
				// }
			}

			if(cur.locate + 1 <= 100_000 && !visit[cur.locate + 1]){
				q.add(new Node(cur.locate + 1, cur.time + 1));
				parent[cur.locate + 1] = cur.locate;
				visit[cur.locate + 1] = true;	
			}			

			if(cur.locate -1 >= 0 && !visit[cur.locate - 1]){
				q.add(new Node(cur.locate -1, cur.time + 1));
				parent[cur.locate-1] = cur.locate;
				visit[cur.locate - 1] = true;	
			}

			if(cur.locate * 2  <= 100_000 && !visit[cur.locate * 2]){
				q.add(new Node(cur.locate * 2, cur.time + 1));				
				parent[cur.locate * 2] = cur.locate;
				visit[cur.locate * 2] = true;	
			}



		}

		System.out.println(min);
		

		Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);			
            index = parent[index];
        }

		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
		
	}
}

class Node{
	int locate, time;
	String cmd = "";

	Node(int a, int b){
		locate = a;
		time = b;
	}

	Node(int a, int b, String c){
		locate = a;
		time = b;
		cmd = c;
	}
}