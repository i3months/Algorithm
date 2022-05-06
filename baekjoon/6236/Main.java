import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;

	static int min = Integer.MIN_VALUE;

	static int[] spend;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		spend = new int[N+1];
		for(int i=1; i<N+1; i++){
			spend[i] = Integer.parseInt(br.readLine());
			if(spend[i] > min){
				min = spend[i];
			}
		}
		
		ParameterSearch();
		
		
	
	}

	static boolean check(int withdraw){
		int cnt = 1;
		int money = 0;

		for(int i=1; i<N+1; i++){
			if(money + spend[i] > withdraw){
				cnt++;
				money = spend[i];
			}else{
				money = money + spend[i];
			}
		}

		return cnt <= M;
	}

	static void ParameterSearch(){
		int L = min;
		int R = 1000000000;
		int ans = 10;

		while(L<=R){

			int mid = (L + R ) / 2;
			if(check(mid)){
				ans = mid;
				R = mid - 1;
			}else{
				L = mid + 1;
			}
		}

		System.out.println(ans);


	}

}