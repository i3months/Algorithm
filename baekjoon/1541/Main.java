import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		String str = br.readLine();

		int ans = 0;
		int minus = 0;

		String origin = str;

		str = str.replace("+", " ");
		str = str.replace("-", " ");

		String[] arr = str.split(" ");

		int idx = 1;

		boolean plus = false;
		boolean sub = false;

		ans = Integer.parseInt(arr[0]);

		for(int i=0; i<origin.length(); i++){
			if(origin.charAt(i) == '+'){				
				if(sub){
					ans = ans - Integer.parseInt(arr[idx]);
				}else{
					ans = ans + Integer.parseInt(arr[idx]);									
				}					
				idx++;
			}

			if(origin.charAt(i) == '-'){
				ans = ans - Integer.parseInt(arr[idx]);
				sub = true;
				idx++;
			}

			// if(i == origin.length() - 1){
			// 	if(sub){
			// 		minus = minus + Integer.parseInt(arr[idx]);
			// 		ans = ans - minus;
			// 	}else{
			// 		if(plus){
			// 			ans = ans + Integer.parseInt(arr[idx]);
			// 		}else{
			// 			ans = ans - Integer.parseInt(arr[idx]);
			// 		}			
			// 	}								
			// }
		}


		System.out.println(ans);
	}
}