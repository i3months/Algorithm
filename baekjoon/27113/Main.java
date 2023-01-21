import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int limit = 1;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = m + 1;

            for (int j = 0; j < x; j++) {
                int c = Integer.parseInt(st.nextToken());
                char d = st.nextToken().charAt(0);

                if (d == 'L') {
                    left = Math.max(left, c);
                } else {
                    right = Math.min(right, c);
                }
            }            

            if (left >= right) {
                if(limit >= right) {
                    limit = Math.max(limit, left + 1);
                } else if(limit < right) {
                    continue;
                }
            } else if(right == left + 1) {
                limit = m+1;
            } else {
                if(limit < right) {
                    limit = Math.max(limit, left + 1);
                } else {
                    limit = m+1;                    
                }
            }

        }

        if(limit == m+1) System.out.println("NO");
        else System.out.println("YES");
    }
}
