import java.util.*;
import java.io.*;

public class Main {	

	static int N;
	static int M;
	
	static int[] arr = new int[10];
	static boolean[] used = new boolean[10001];
	static HashSet<Integer> list2 = new HashSet<>();
	static ArrayList<Integer> list;

	static StringBuilder sb = new StringBuilder();

	static int num_cnt[] = new int[10001];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		while(st.hasMoreTokens()){
			int temp = Integer.parseInt(st.nextToken());
			list2.add(temp);
			num_cnt[temp]++;
			
		}

		list = new ArrayList<>(list2);

		Collections.sort(list);
		

		solve(0);

		System.out.println(sb);

	}

	static void solve(int k){

		if(k == M){			
			for(int i=0; i<M; i++){
				sb.append(arr[i] + " ");
				//System.out.print(arr[i] + " ");
			}
			//System.out.println();
			sb.append("\n");
			return;			
		}

		for(int i=0; i<list.size(); i++){					
					arr[k] = list.get(i);
					used[list.get(i)] = true;
					solve(k+1);
					used[list.get(i)] = false;	
												
		}
		
	}

}