import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
		public static void main(String[] args) throws IOException {			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list  = new ArrayList<>();
			if(N != 0){
				st = new StringTokenizer(br.readLine());
			}			

			for(int i=0; i<N; i++){
				list.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(list, Collections.reverseOrder());

			if(N == P && target <= list.get(list.size() - 1)){
				System.out.println(-1);
				return;
			}

			int rank = 1;

			for(int i=0; i<list.size(); i++){
				if(target < list.get(i)){
					rank++;
				}else{
					break;
				}
			}

			System.out.println(rank);
			
	}
}