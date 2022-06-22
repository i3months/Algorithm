import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N-1];

		long player = Long.parseLong(st.nextToken());

		for(int i=0; i<N-1; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		boolean chk = false;

		for(int i=0; i<N-1; i++){
			if(arr[i] < player){
				player = player + arr[i];
			}else{
				chk = true;
			}
		}

		if(chk){
			System.out.println("No");
		}else{
			System.out.println("Yes");
		}

		

		

	}
}