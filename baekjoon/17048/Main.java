import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	    				
		
		int N = Integer.parseInt(br.readLine());
		
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine())	;

		for(int j=0; j<N; j++){
			arr1[j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine())	;
		
		for(int j=0; j<N; j++){
			arr2[j] = Integer.parseInt(st.nextToken());
		}

		Point[] arr = new Point[N];

		for(int i=0; i<N; i++){
			arr[i] = new Point(arr1[i], arr2[i]);
		}
				
		HashMap<Integer, Integer> hm = new HashMap<>();

		int max = 0;

		for(int i=0; i<N; i++){
			int tmp = arr[i].c - arr[i].r;

			if(!hm.containsKey(tmp)){
				hm.put(tmp, 1);				
			}else{
				hm.put(tmp, hm.get(tmp) + 1);
			}

			int comp = hm.get(tmp);

			if(comp >= max){
				max = comp;
			}
		}

		System.out.println(max);
		
		
	}
}

class Point{
	int r, c;
	Point(int a, int b){
		r = a;
		c = b;
	}
}
