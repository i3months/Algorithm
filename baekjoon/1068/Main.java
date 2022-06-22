import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	static int N;	
	static ArrayList<Integer>[] list;
	static int[] leaf;
	static int root;
	static int delete;

	static int cnt;

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

			N = Integer.parseInt(br.readLine());
			list = new ArrayList[N];
			leaf = new int[N];
			
			for(int i=0; i<N; i++){
				list[i] = new ArrayList<>();
			}

			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0; i<N; i++){
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == -1){
					root = i;
					continue;
				}
				list[tmp].add(i);
			}
			delete = Integer.parseInt(br.readLine());			

			for(int i =0; i<N; i++){
				if(list[i].contains(delete)){
					list[i].remove(list[i].indexOf(delete));
				}
			}

			if(root != delete){
				dfs(root, -1);
				System.out.println(cnt);
			}else{
				System.out.println(0);
			}
				
	}


	static void dfs(int x, int parent){
		if(list[x].isEmpty()){
			cnt++;
		}
		for(int y: list[x]){
			if(y == parent){
				continue;
			}
			dfs(y,x);			
		}
	}
}