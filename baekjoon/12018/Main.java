import java.util.*;
import java.io.*;
import java.math.*;

public class Main {				
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Lecture[] lec = new Lecture[N];
			
			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());

				lec[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				st = new StringTokenizer(br.readLine());

				for(int j=0; j<lec[i].P; j++){
					lec[i].arr[j] = Integer.parseInt(st.nextToken());
				}				
				
				Arrays.sort(lec[i].arr);
			}

			// 입력 끝

			ArrayList<Integer> list = new ArrayList<>();

			for(int i=0; i<N; i++){
				int limit = lec[i].L;
				int num = lec[i].P;
				if(limit > num){
					list.add(1);
				}else{
					list.add(lec[i].arr[num - limit]);
				}				
			}

			Collections.sort(list);

			int sum = 0;
			int cnt = 0;

			for(int i=0; i<list.size(); i++){
				sum = sum + list.get(i);				
				if(sum > M){
					break;
				}else{
					cnt++;
				}
			}


			System.out.println(cnt);


			
	}	
}

class Lecture{
	int P;
	int L;

	int[] arr;

	Lecture(int a, int b){
		P = a;
		L = b;

		arr = new int[P];

		
	}
}