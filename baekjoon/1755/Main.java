import java.util.*;
import java.io.*;

public class Main {

	String[] name_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int fin = Integer.parseInt(st.nextToken());

		Num[] arr = new Num[fin - start + 1];

		for(int i = 0; i<fin - start + 1; i++){
			arr[i] = new Num(i+start);
		}

		Arrays.sort(arr);

		int cnt = 0;
		for(int i=0; i<fin-start + 1; i++){			
			if(cnt == 10){
				cnt = 0;
				sb.append("\n");
			}
			cnt++;
			sb.append(arr[i].num + " ");
		}

		System.out.println(sb);

		
		

		

	}
}

class Num implements Comparable<Num>{
	String[] name_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	int num;
	String str;

	Num(int a){
		num = a;
		String temp = String.valueOf(a);
		for(int i=0; i<temp.length();i ++){
			str = str + name_arr[temp.charAt(i) - '0'];
		}		
	}

	public int compareTo(Num o2){
		return str.compareTo(o2.str);
	}
}