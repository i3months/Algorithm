import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=1; i<N+1; i++){
			list.add(i);
		}

		while(true){
			if(list.size() == 1){
				break;
			}

			for(int i=0; i<(list.size() / 2) + 1; i++){
				list.remove(i);

				if(list.size() == 1){
					break;
				}

			}
		}

		System.out.println(list.get(0));

	}
}