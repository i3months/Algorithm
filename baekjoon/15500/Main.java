import java.util.*;
import java.io.*;
 
public class Main {
 
	static StringBuilder sb;
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();
		Stack<Integer> st3 = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();


		for(int i=0; i<N; i++){	
			st1.add(Integer.parseInt(st.nextToken()));	
		}


		int cnt = 0;
		int target = N;		

		while(true){

			if(st3.size() == N){
				break;
			}


			while(!st1.empty()){
				int temp = st1.pop();
				cnt++;

				if(temp == target){
					st3.push(temp);
					target--;
					sb.append(1 + " " + 3 + "\n");
					if(target == 0){
						break;
					}
				}else{
					st2.push(temp);
					sb.append(1 + " " + 2 + "\n");
				}
			}

			while(!st2.empty()){
				int temp = st2.pop();
				cnt++;

				if(temp == target){
					st3.push(temp);
					target--;
					sb.append(2 + " " + 3 + "\n");
					if(target == 0){
						break;
					}
				}else{
					st1.push(temp);
					sb.append(2 + " " + 1 + "\n");
				}
			}



		} // end of first while

		System.out.println(cnt);
		System.out.println(sb);


		
	}
}