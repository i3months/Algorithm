import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();      
    static final int INF = 987654321;  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());        

        int[][] map = new int[n+1][n+1];
        
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        for(;;) {
            StringTokenizer st = new StringTokenizer(br.readLine());            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1) break;
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int k=1; k<n+1; k++) {
            for(int i=1; i<n+1; i++) {
                for(int j=1; j<n+1; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
                }
            }
        }

        int[] arr = new int[n+1];

        for(int i=1; i<n+1; i++) {
            int val = -1;
            for(int j=1; j<n+1; j++) {
                if(map[i][j] == INF) continue;
                val = Math.max(val, map[i][j]);
            }
            arr[i] = val;
        }

        int minVal = INF;

        for(int i=1; i<n+1; i++) {
            minVal = Math.min(minVal, arr[i]);
        }

        int cnt = 0;
        

        for(int i=1; i<n+1; i++) {
            if(arr[i] == minVal) {
                sb.append(i + " ");
                cnt++;
            }
        }

        System.out.println(minVal + " " + cnt);
        System.out.println(sb);



    }
}

