import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int N = Integer.parseInt(br.readLine());

		String[] arr = new String[N];

		for(int i=0; i<N; i++){
			arr[i] = br.readLine();			
		}

		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2){
				if(o1.length() >= o2.length()){
					return -1;
				}else{
					return 1;
				}

			}
		});

		// for(String k : arr){
		// 	System.out.print(k + " ");
		// }

		HashSet<String> hs = new HashSet<>();

		for(String k : arr){
			if(hs.size() == 0){
				hs.add(k);
				continue;
			}

			boolean chk = true;
			for(String l : hs){
				if(l.indexOf(k) == 0){
					chk = false;
					break;
				}
			}

			if(chk){
				hs.add(k);
			}

		}

		System.out.println(hs.size());

	}
}