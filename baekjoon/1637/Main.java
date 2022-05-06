import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] input;
	
	//static long ans_num;

	static int max = Integer.MIN_VALUE;	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());		
		
		input = new int[N][3];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		BinarySearch();

		
	}

	static long count(long A, long C, long B, long Upper){
		if(Upper < A){
			return 0;
		}

		if(C < Upper){
			return ((C - A) / B) + 1;
		}else{
			return ((Upper - A) / B) + 1;
		}
	}

	static boolean odd_check(long p){
		long sum = 0;
		for(int i=0; i<N; i++){
			sum = sum + count(input[i][0], input[i][1], input[i][2], p);
		}

		if(sum % 2 == 1){
			//ans_num = sum;
			return true;
		}else{
			return false;
		}
	}

	static void BinarySearch(){
		long L = 1;
		long R = Integer.MAX_VALUE;
		long ans = 0;

		while(L <= R){
			long mid = ( L + R ) / 2;
			if(odd_check(mid)){
				ans = mid;
				R = mid - 1;
			}else{
				L = mid + 1;
			}
		}

		long ans_cnt = 0;


		if(ans == 0){
			System.out.println("NOTHING");			
		}else{						
			for (int i = 0; i < N; i++) {
				if (input[i][0] <= ans && ans <= input[i][1] && (ans - input[i][0]) % input[i][2] == 0) {
						ans_cnt++;
				}
		}
		System.out.println(ans + " " + ans_cnt);
		}
	}

}