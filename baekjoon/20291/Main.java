import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hm = new HashMap<>();

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			String temp = st.nextToken();
			String temp2 = st.nextToken();

			if(hm.containsKey(temp2)){
				hm.put(temp2, hm.get(temp2) + 1);
			}else{
				hm.put(temp2, 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(hm.keySet());


		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i) + " " + hm.get(list.get(i)));
		}
		


	}
}