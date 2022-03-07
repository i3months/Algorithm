import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] x = new int[N];
		int[] y = new int[N];

		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(x);
		Arrays.sort(y);

		int ans = (x[N-1] - x[0]) * (y[N-1] - y[0]);
		System.out.println(ans);

		
	}
}