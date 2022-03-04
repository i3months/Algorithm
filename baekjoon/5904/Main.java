import java.io.*;
import java.util.*;

public class Main {
	
	static char[] moo_arr = {'m', 'o', 'o'};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		moo(N,1,3);


		
	}
	static void moo(int n, int k, int len){
		int moo_len = len*2 + k+3; // 수열의 길이 k가 1일 경우는 S(1)

		if(n <= 3){
			System.out.println(moo_arr[n-1]);
			return;
		} // n이 3 이하면 재귀 돌릴 필요 없이 바로 답 구함

		if(moo_len < n){
			moo(n, k+1, moo_len); // 우선 수열의 길이를 입력받은 수보다 크게 맞춤. (재귀 사용)
		}else{
			if(n > len && n <= len + k + 3){ // 입력받은 수가 가운데에 위치할 때.. (k+3 부분)
				if(n-len != 1){ // 첫번째가 아니면 o 첫번째면 m으로 바로 구할 수 있다.
					System.out.println('o');
				}else{
					System.out.println('m');
				}
				return;
			}else{
				moo(n-(len+k+3), 1, 3); // 가운데 부분이 아니면 다시 재귀를 돌려 탐색을 진행한다.
			}
		}
	}
}