import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                for(int k=1; k<n+1; k++) {
                    if(map[j][i] == 1 && map[i][k] == 1) {
                        map[j][k] = 1;
                    }
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            int cnt = 0;
            for(int j=1; j<n+1; j++) {
                if(i == j) continue;
                if(map[i][j] == 0 && map[j][i] == 0) cnt++;
            }
            System.out.println(cnt);
        }

    }
}

