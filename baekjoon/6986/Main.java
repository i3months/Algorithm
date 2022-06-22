	import java.util.*;
	import java.io.*;
	import java.math.*;

	public class Main {	
		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			

				StringTokenizer st = new StringTokenizer(br.readLine());

				int N = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());

				double[] arr = new double[N];

				for(int i=0;i <N; i++){
					arr[i] = Double.parseDouble(br.readLine());
				}

				Arrays.sort(arr);

				double sum = 0.0;

				for(int i=K; i<N-K; i++){
					sum = sum + arr[i];
				}

				double jeol = sum / (double)(N - K - K);

				jeol = Math.round(jeol * 100.0) / 100.0;

				for(int i=0; i<K; i++){
					arr[i] = arr[K];
				}

				for(int i=N-K; i<N; i++){
					arr[i] = arr[N-K - 1];
				}

				double sum2 = 0;

				for(int i=0; i<N; i++){
					sum2 = sum2 + arr[i];
				}

				double bo = sum2 / (double)N;

				bo = Math.round(bo * 100.0) / 100.0;

				System.out.println(jeol + "\n" + bo);


		}
	}