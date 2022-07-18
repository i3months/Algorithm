import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<Integer>[] list;
	static int visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for(int TC = 0; TC < T; TC++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			visit = new int[V+1];
			list = new ArrayList[V+1];

			for(int i = 0; i <= V; i++)
				list[i] = new ArrayList<Integer>();

			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				list[p1].add(p2);
				list[p2].add(p1);
			}

			solve();
      
		}
	}

	public static void solve() {
		Queue<Integer> q = new LinkedList<Integer>();

		for(int i = 1; i <= V; i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}

			while(!q.isEmpty()) {
				int now = q.poll();

				for(int j = 0; j < list[now].size(); j++) {
					if(visit[list[now].get(j)] == 0) {
						q.add(list[now].get(j));
					}
					
					if(visit[list[now].get(j)] == visit[now]) {
						System.out.println("NO");
						return;
					}

					if(visit[now] == 1 && visit[list[now].get(j)] == 0)
						visit[list[now].get(j)] = 2;
					else if(visit[now] == 2 && visit[list[now].get(j)] == 0)
						visit[list[now].get(j)] = 1;
				}
			}
		}

		System.out.println("YES");
	}

}