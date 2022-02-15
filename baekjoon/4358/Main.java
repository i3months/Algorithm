import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		HashMap<String, Integer> hash = new HashMap<>();

		while(true){
			String str = br.readLine();
			count = count + 1;
			if(str == null || str.equals("")){
				break;
			}
			
			hash.put(str, hash.getOrDefault(str,0)+1);
		}

		Object[] key = hash.keySet().toArray();
		Arrays.sort(key);

		for(int i=0; i<key.length; i++){
			double ans = ((double)(hash.get(key[i])) / (double)(count)) * 100;
			sb.append(key[i]).append(" ").append(String.format("%.4f", ans)).append('\n');
			
		}
		System.out.println(sb);
	
		
	}
}