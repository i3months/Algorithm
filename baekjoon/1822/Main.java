import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int cnt = 0;

		st = new StringTokenizer(br.readLine());

		HashSet<Integer> hs_1 = new HashSet<>();
		HashSet<Integer> hs_2 = new HashSet<>();

		for(int i=0; i<A; i++){
			hs_1.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i <B; i++){
			hs_2.add(Integer.parseInt(st.nextToken()));
		}

		ArrayList<Integer> list = new ArrayList<>(hs_1);

		Collections.sort(list);

		for(int i=0; i<list.size(); i++){
			if(hs_2.contains(list.get(i))){				
			}else{
				sb.append(list.get(i) + " ");
				cnt++;
			}
		}

		System.out.println(cnt);
		System.out.println(sb);

		

	}
}