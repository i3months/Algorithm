import java.util.*;
import java.io.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = "";
/*
		while((input = br.readLine()) != null){
				String[] tmp = input.split(" ");
				int a = Integer.parseInt(tmp[0]);
				int b = Integer.parseInt(tmp[1]);

				int cnt = 0;

				for(int i=a; i<b; i++){
						if(check(i)){
							cnt++;
						}
				}

				System.out.println(cnt);


		}
*/

while((input = br.readLine()) != null){	


	String[] tmp = input.split(" ");
	int a = Integer.parseInt(tmp[0]);
	int b = Integer.parseInt(tmp[1]);

	int cnt = 0;

	for(int i=a; i<b+1; i++){
			if(check(i)){
				cnt++;
			}
	}

	System.out.println(cnt);


}

	}

	static boolean check(int N){
		String temp = String.valueOf(N);
		
		int len = temp.length();

		int[] arr = new int[10];

		for(int i=0; i<len; i++){
			arr[temp.charAt(i) - '0']++;
		}

		for(int i=0; i<10; i++){
			if(arr[i] >= 2){
				return false;
			}
		}		
		return true;
	}

}