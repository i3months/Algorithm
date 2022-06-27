import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		int N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());					

			bfs(A,B);
			
		}
			
		
	}

	static void bfs(int a, int b){
		Queue<Integer> q = new LinkedList<>();

		boolean[] visit = new boolean[10001];
		String[] cmd = new String[10001];	

		Arrays.fill(cmd, "");

		visit[a] = true;
		q.add(a);

		while(!q.isEmpty() && !visit[b]){
			int tmp = q.poll();

			int D = (2 * tmp) % 10000;
			int S = tmp - 1;
			if(S == -1){
				S = 9999;				
			}			
			int L = ((tmp % 1000) * 10) + (tmp / 1000);
			int R = (tmp % 10) * 1000 + (tmp / 10);

			if(!visit[D]){
				q.add(D);
				visit[D] = true;
				cmd[D] = cmd[tmp] + "D";
			}

			if(!visit[S]){
				q.add(S);
				visit[S] = true;
				cmd[S] = cmd[tmp] + "S";
			}

			if(!visit[L]){
				q.add(L);
				visit[L] = true;
				cmd[L] = cmd[tmp] + "L";
			}

			if(!visit[R]){
				q.add(R);
				visit[R] = true;
				cmd[R] = cmd[tmp] + "R";
			}

		}

		System.out.println(cmd[b]);
	}
}