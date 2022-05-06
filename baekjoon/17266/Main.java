import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int M;

	static int max = Integer.MIN_VALUE;

	static int[] light;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());		
		M = Integer.parseInt(br.readLine());

		light = new int[M+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=1; i<M+1; i++){
			light[i] = Integer.parseInt(st.nextToken());
		}

		BinarySearch();
	

	}

	static boolean check(int h){
		//int last_idx = 0;
		int last_idx = 0;

		for(int i=1; i<M+1; i++){
			if(light[i] - last_idx <= h){
				last_idx = light[i] + h;
			}else{
				return false;
			}
		}
		return last_idx >= N;
	}

	static void BinarySearch(){
		int L = 0;
		int R = N;
		int ans = N;

		Arrays.sort(light, 1, M+1);
		
		while(L <= R){
			int mid = (L + R) / 2;
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