import java.io.*;
import java.util.*;

public class Main {			
	static int N, M;
	static int[] arr;	
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		visit = new boolean[N];

		for(int i=0; i<N; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);		
		}

		for(int i=0; i<N; i++){
			// visit = new boolean[N];
			visit[i] = true;
			dfs(i, 0);
			visit[i] = false;
		}
	
		System.out.println(0);
				
		

    }
	static void dfs(int idx, int depth){

		if(depth == 4){
			System.out.println(1);
			System.exit(0);
		}
				

		for(int k : list[idx]){
			if(!visit[k]){
				visit[k] = true;
				dfs(k, depth + 1);
				visit[k] = false;
			}
		}	
		
		
	}
}