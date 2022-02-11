import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> pokemon = new HashMap<>();

	

		for(int i=1; i<N+1; i++){
			String pokename = br.readLine();
			String temp = String.valueOf(i);
			pokemon.put(pokename,temp);
			pokemon.put(temp,pokename);
		}
		

		for(int i=0; i<M; i++){
			String quiz = br.readLine();
			if(quiz.charAt(0) >= '0' && quiz.charAt(0) <= '9'){
				int quiznum = Integer.parseInt(quiz);
				sb.append(pokemon.get(quiz)).append('\n');
			}else{
				sb.append(pokemon.get(quiz)).append('\n');
			}
		}
		
		System.out.println(sb);
		

	}
}