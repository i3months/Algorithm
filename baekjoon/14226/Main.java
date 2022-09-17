import java.io.*;
import java.util.*;

import javax.sound.sampled.Clip;

public class Main {	
	static int S;
	static int[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));								
		
		S = Integer.parseInt(br.readLine());

		visit = new int[8888][8888];

		visit[1][0] = 1;

		Queue<Node> q = new LinkedList<>();

		q.add(new Node(1,0));
		
		while(!q.isEmpty()){
			Node cur = q.poll();

			if(cur.display == S){
				System.out.println(visit[cur.display][cur.clipboard] - 1);
				return;
			}

			if(cur.display > 0 && cur.display <= 2000){
				int display = cur.display;
				int clipboard = display;

				if(visit[display][clipboard] == 0){
					visit[display][clipboard] = visit[cur.display][cur.clipboard] + 1;
					q.add(new Node(display, clipboard));					
				}

			}

			if(cur.clipboard > 0 && cur.clipboard <= 2000){
				int display = cur.display + cur.clipboard;
				int clipboard = cur.clipboard;

				if(visit[display][clipboard] == 0){
					visit[display][clipboard] = visit[cur.display][cur.clipboard] + 1;
					q.add(new Node(display, clipboard));					
				}
			}

			if(cur.display > 0){
				int display = cur.display - 1;
				int clipboard = cur.clipboard;

				if(visit[display][clipboard] == 0){
					visit[display][clipboard] = visit[cur.display][cur.clipboard] + 1;
					q.add(new Node(display, clipboard));					
				}
			}
			
			
		}

		int min = 987654321;

		for(int i = 0; i<2001; i++){
			if(visit[S][i] == 0) continue;
			min = Math.min(min, visit[S][i]);
		}

		System.out.println(min);

		for(int i=0; i<10; i++){
			System.out.print(visit[S][i] + " ");
		}
		
	}
}

class Node{
	int display, clipboard;

	Node(int a, int b){
		display = a;
		clipboard = b;
	}
}