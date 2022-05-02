import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		ArrayList<String> list = new ArrayList<>();

		ArrayList<String> origin = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		ArrayList<String> list3 = new ArrayList<>();

		for(int i =0; i<N; i++){
			list.add(br.readLine());
		}

		for(int i =0; i<N; i++){
			origin.add(list.get(i));
		}

		Collections.sort(list, Collections.reverseOrder());

		for(int i =0; i<N; i++){
			list2.add(list.get(i));
		}


		Collections.sort(list);

		for(int i =0; i<N; i++){
			list3.add(list.get(i));
		}

		
		boolean chk1 = true;		
		boolean chk2 = true;

		for(int i=0; i<N; i++){
			if(origin.get(i).equals(list2.get(i))){
				continue;
			}else{
				chk1 = false;
				break;
			}
		}

		for(int i=0; i<N; i++){
			if(origin.get(i).equals(list3.get(i))){
				continue;
			}else{
				chk2 = false;
				break;
			}
		}
		

		if(chk1){
			System.out.println("DECREASING");
		}

		if(chk2){
			System.out.println("INCREASING");
		}

		if(!chk1 && !chk2){
			System.out.println("NEITHER");
		}


		

		
		
		

	}

}