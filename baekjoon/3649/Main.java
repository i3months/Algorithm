	import java.io.*;
	import java.util.*;

	public class Main {

		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			

			try{
				while(true){
					int X = Integer.parseInt(br.readLine());
					int N = Integer.parseInt(br.readLine());

					X = X * 10000000;

					int arr[] = new int[N];

					for(int i=0; i<N; i++){
						arr[i] = Integer.parseInt(br.readLine());
					}

					Arrays.sort(arr);

					int L = 0;
					int R = N-1;

					while(L < R){
						int sum = arr[L] + arr[R];
						if(sum == X){
							break;
						}

						if(sum < X){
							L++;
						}

						if(sum > X){
							R--;
						}

					}

					if(L >= R){
						System.out.println("danger");
					}else{
						System.out.println("yes" + " " + arr[L] + " " + arr[R]);
					}
				}
			}catch(Exception e){
				System.out.println();
			}

		}	
	}