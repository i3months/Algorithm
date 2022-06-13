import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] shooter = new int[M];

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<M; i++){
			shooter[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(shooter);

		locate animal[] = new locate[N];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			animal[i] = new locate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;

		for(int i=0; i<N; i++){
			int left = 0;
			int right = M;
			
			while(left <= right){
				int mid = (left + right) / 2;
				if(mid >= M){
					break;
				} 

				int distance = Math.abs(shooter[mid] - animal[i].r) + animal[i].c;
				
				if(L < distance && animal[i].r < shooter[mid]){
					right = mid - 1;
				}else if(L < distance && animal[i].r >= shooter[mid]){
					left = mid + 1;
				}else if(L >= distance){
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);
		
	}	
}

class locate{
	int r;
	int c;
	locate(int a, int b){
		r = a;
		c = b;
	}
}