import java.util.*;
import java.io.*;
import java.math.*;

public class Main {			
    static final int INF = 987654321;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r, c, n, m;
		int ans = 0;
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int maxR = -1;
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());

			int rr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());

			maxR = Math.max(maxR, rr);
			list.add(cc);			
		}

		Collections.sort(list);


		int left = maxR;
		int right = INF;

		while(left <= right) {
			int mid = (left + right) / 2;			

			int prev = -1;
			int res = 0;			

			for(int k : list) {
				if(prev == -1) {
					prev = k;
					res++;
					continue;
				}

				if(prev + mid <= k) {
					prev = k;
					res++;
				}				
			}

			if(res <= n) {
				ans = mid;
				right = mid-1;								
			} else {
				left = mid+1;							
			}			

		}

		System.out.println(ans);

    }
}
