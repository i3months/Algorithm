import java.util.*;
import java.io.*;

public class Main {	

	static int N;
	static int M;
	
	static int[] arr = new int[10];
	static boolean[] used = new boolean[10001];
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);
		

		solve(0);

	}

	static void solve(int k){

		if(k == M){
			for(int i=0; i<M; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;			
		}

		for(int i=0; i<N; i++){
			if(k >= 1){
				if(!used[list.get(i)] && arr[k-1] < list.get(i)){
					arr[k] = list.get(i);
					used[list.get(i)] = true;
					solve(k+1);
					used[list.get(i)] = false;
				}
			}else{
				if(!used[list.get(i)]){
					arr[k] = list.get(i);
					used[list.get(i)] = true;
					solve(k+1);
					used[list.get(i)] = false;
				}
			}		
			
		}
		
	}

}