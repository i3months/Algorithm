import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());

		ArrayList<Person> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<N+1; i++){
			list.add(new Person(i, Integer.parseInt(st.nextToken())))	;
		}

		int next = 0;

		while(true){
			Person tmp = list.get(next);					
			
			int cycle = tmp.K + next;

			int size = list.size();

			int remain = cycle % size;
			
			remain = remain - 1;

			if(remain == -1){
				remain = size - 1;
			}

			list.remove(remain);

			next = remain;			

			if(remain == list.size()){
				next = 0;
			}


			if(list.size() == 1){
				break;
			}
			
		}

		System.out.println(list.get(0).num);

	}		
}

class Person{
	int num;
	int K;

	Person(int a, int b){
		num = a;
		K = b;
	}
}
