import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int Z = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			boolean[] arr = new boolean[N+1];

			st = new StringTokenizer(br.readLine());

			for(int i=0; i<M; i++){
				arr[Integer.parseInt(st.nextToken())] = true;
			}

			int ans = -1;

			loop1 : for(int i=1; i<1000; i++){
				int tmp = 1;
				boolean[] visit = arr.clone();

				while(tmp < 1000){
					if(tmp == Z){
						ans = i;
						break loop1;
					}
					if(!visit[tmp]){
						visit[tmp] = true;
					}else{
						break;
					}
					tmp = tmp + i;
					if( tmp > N){
						tmp = tmp - N;
					}
				}
				
			}

			System.out.println(ans);
			
	}
}