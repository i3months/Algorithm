import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Serial[] arr = new Serial[N];

		for(int i=0; i<arr.length; i++){
			arr[i] = new Serial(br.readLine());
		}

		Arrays.sort(arr);

		for(int i=0; i<N; i++){
			System.out.println(arr[i].num);
		}

	}

}

class Serial implements Comparable<Serial>{
	String num;

	Serial(String a){
		num = a;
	}

	@Override
	public int compareTo(Serial o2){
		
		if(num.length() > o2.num.length()){
			return 1;
		}else if(num.length() < o2.num.length()){
			return -1;
		}else{
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0;i <num.length(); i++){
				if(num.charAt(i) >= '0' &&  num.charAt(i) <= '9'){
					sum1 =sum1 + num.charAt(i) - '0';
				}
			}
			for(int i=0;i <o2.num.length(); i++){
				if(o2.num.charAt(i) >= '0' &&  o2.num.charAt(i) <= '9'){
					sum2 =sum2 + o2.num.charAt(i) - '0';
				}
			}

			if(sum1 > sum2){
				return 1;
			}else if(sum1 <sum2){
				return -1;
			}else{
				return num.compareTo(o2.num);
			}

		}
	}
}