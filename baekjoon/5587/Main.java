import java.util.*;
import java.io.*;
import java.math.*;

public class Main {	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

			int N = Integer.parseInt(br.readLine());
			
			int[] A = new int[N];
			int[] B = new int[N];

			boolean[] A1 = new boolean[N];
			boolean[] B1 = new boolean[N];

			boolean[] arr = new boolean[2 * N + 1];

			for(int i=0; i<N; i++){
				int tmp = Integer.parseInt(br.readLine());
				A[i] = tmp;				
				arr[tmp] = true;
			}

			for(int i=0; i<N; i++){
				for(int j=1; j<2 * N + 1; j++){
					if(!arr[j]){
						B[i] = j;
						arr[j] = true;
						break;
					}
				}
			}
			
			Arrays.sort(A);
			Arrays.sort(B);

			int cnt1 = 0;
			int cnt2 = 0;

			int upper = 0;

			while(true){

				boolean chk1 = false;
				
				for(int i=0; i<N; i++){
					if(upper < A[i] && !A1[i]){
						upper = A[i];
						A1[i] = true;
						cnt1++;
						chk1 = true;
						break;
					}
				}

				if(cnt1 == N){
					break;
				}

				if(!chk1){
					upper = 0;
				}

				boolean chk2 = false;

				for(int i=0; i<N; i++){
					if(upper < B[i] && !B1[i]){
						upper = B[i];
						B1[i] = true;
						cnt2++;
						chk2 = true;
						break;
					}
				}

				if(!chk2){
					upper = 0;
				}

				if(cnt2 == N){
					break;
				}

			}


			System.out.println((N - cnt2) + "\n" + (N - cnt1));
			

			
	}
}