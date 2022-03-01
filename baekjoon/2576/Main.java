import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[7];

		for(int i=0; i<7; i++){
			int temp = Integer.parseInt(br.readLine());
			arr[i] = temp;	
		}
		ArrayList<Integer> list = new ArrayList();
		for(int i=0; i<7; i++){
			if(arr[i] % 2 == 1){
				list.add(arr[i]);
			}
		}

		Collections.sort(list);

		int ans = 0;
		for(int i=0; i<list.size(); i++){
			ans = ans + list.get(i);
		}

		if(ans == 0){
			System.out.print("");
		}else{
			System.out.println(ans);
		}
		
		if(list.isEmpty()){
			System.out.println(-1);
		}else{
			System.out.println(list.get(0));
		}
		

	}
}