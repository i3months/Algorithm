import java.util.*;
import java.io.*;

public class Main {	

  static int L, C = 0;
  static int[] arr = new int[15];
  static char[] cand;  
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cand = new char[C];

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<C; i++){
			cand[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(cand);

		solve(0,0);
		
	}

	static void solve(int k, int start){
		if(k == L){
			boolean chk = false;		
			int cnt1 = 0;
			int cnt2 = 0;

			for(int i =0; i<L; i++){
				if(cand[arr[i]] == 'a' || cand[arr[i]] == 'e' || cand[arr[i]] == 'i' || cand[arr[i]] == 'o' || cand[arr[i]] == 'u'){
					cnt1++;
				}else{
					cnt2++;
				}
			}

			if(cnt1 >= 1 && cnt2 >= 2){
				chk = true;
			}

			if(chk){
				for(int i=0; i<L; i++){
					System.out.print(cand[arr[i]]);
				}
				System.out.println();
			}

		}	
		
		// 중복해서 써도 됨.  즉, used필요없음
		for(int i = start; i<C; i++){
			arr[k] = i;
			solve(k+1, i+1);
		}
	}

}