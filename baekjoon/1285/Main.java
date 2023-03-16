import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int INF = 987654321;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                if(str.charAt(j) == 'T') map[i][j] = 1;
            }
        }
        int ans = INF;

        for(int i=0; i<(1 << n)-1; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                int tail = 0;
                for(int k=0; k<n; k++) {
                    int cur = map[k][j];
                    if((i & (1 << k)) != 0) cur = (map[k][j] ^ 1);
                    if(cur == 1) tail++;
                }
                sum += Math.min(tail, n - tail);
            }
            ans = Math.min(ans, sum);
        }

        System.out.println(ans);
    }
}
