	import java.io.*;
	import java.util.*;

	public class Main {

		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();

			int T = Integer.parseInt(br.readLine());

			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N+1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=1; i<N+1; i++){
				arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());

			int[] arr2 = new int[M+1];

			st = new StringTokenizer(br.readLine());

			for(int i=1; i<M+1; i++){
				arr2[i] = arr2[i-1] + Integer.parseInt(st.nextToken());
			}

			long ans = 0;

			HashMap<Integer, Integer> hm = new HashMap<>();

			for(int i=1; i<N+1; i++){
				for(int j=i; j<N+1; j++){
					int tmp = arr[j] - arr[i-1];
					
					if(hm.containsKey(tmp)){
						hm.put(tmp, hm.get(tmp) + 1);
					}else{
						hm.put(tmp, 1);
					}
				}
			}

			for(int i=1; i<M+1; i++){
				for(int j = i; j<M+1; j++){
					int tmp = arr2[j] - arr2[i-1];
					int target = T - tmp;

					if(hm.containsKey(target)){
						ans = ans + hm.get(target);
					}

				}
			}

			System.out.println(ans);
			
		}
	}