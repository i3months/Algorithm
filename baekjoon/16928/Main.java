import java.util.*;
import java.io.*;
import java.math.*;

public class Main {		
	static int N, M;
	static int count[] = new int[101];
	
	static int[] object = new int[101];
	static boolean visit[] = new boolean[101];	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0; i<N + M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			object[a] = b;
		}
		System.out.println(bfs());
						
	}
	static int bfs(){
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		count[1] = 0;
		visit[1] = true;

		while(!q.isEmpty()){
			int tmp = q.poll();			

			if(tmp == 100){
				return count[100];
			}	

			for(int i=1; i<7; i++){
				int next = tmp + i;
				if(100 < next){
					continue;
				}
				if(visit[next]){
					continue;
				}
				visit[next] = true;

				if(object[next] != 0){
					if(!visit[object[next]]){
						q.add(object[next]);
						visit[object[next]] = true;
						count[object[next]] = count[tmp] + 1;
					}
				}else{
					q.add(next);
					count[next] = count[tmp] + 1;
				}
			}			
		}

		return -1;
	}
}