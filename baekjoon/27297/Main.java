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

        long[][] arr = new long[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++) {
                long a = Long.parseLong(st.nextToken());
                arr[i][j] = a;                
            }
        }

        long[][] spin = new long[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                spin[i][j] = arr[j][i];
            }
        }

        long ans = 0;
        
        for(int i=0; i<n; i++) {
            Arrays.sort(spin[i]);
            for(int j=0; j<m; j++) {
                ans += Math.abs(spin[i][j] - spin[i][m / 2]);
            }
        }

        System.out.println(ans);

        for(int i=0; i<n; i++) {
            System.out.print(spin[i][m/2] + " ");
        }
        

    }
}
