import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;

	static int[] money;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		money = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int max = 0;

		for(int i=1; i<N+1; i++){
			money[i] =Integer.parseInt(st.nextToken());
			
			if(max < money[i]){
				max = money[i];
			}

		}

		M = Integer.parseInt(br.readLine());
		
		int sum = 0;

		for(int i=0; i<N; i++){
			sum = sum + money[i];
		}

		System.out.println(ParaSearch(max));
		

	}

	static boolean check(int max_val){
		int sum = 0;
		for(int i = 1; i< N + 1; i++){
			sum = sum + Math.min(money[i], max_val);
		}

		if(sum <= M){
			return true;
		}else{
			return false;
		}
	}

	static int ParaSearch(int R){ 	
		int L = 0; 		
		int ans = 0;

		while(L <= R){
			int mid = (L + R) / 2;
			if(check(mid)){
				ans = mid;
				L = mid + 1;
			}else{
				R = mid - 1;
			}
		}

		return ans;


	}
}