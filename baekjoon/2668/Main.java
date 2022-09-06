import java.io.*;
import java.util.*;

public class Main {			
	static int N;
	static int[] arr;	
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		visit = new boolean[N + 1];

		for(int i=1; i<N+1; i++){
			arr[i] = Integer.parseInt(br.readLine());	
		}		

		for(int i=1; i<N+1; i++){
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}

		Collections.sort(list);

		System.out.println(list.size());

		for(int k :list){
			System.out.println(k);
		}
		

		

	}

	static void dfs(int start, int target) {
		if(arr[start] == target) list.add(target);

        if(visit[arr[start]] == false) {
            visit[arr[start]] = true;
            dfs(arr[start], target);
            visit[arr[start]] = false; // 사이클 못 만나면 싹다 지워줘야 함.
        }        
    }
}