import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                                    
                    
        int N = Integer.parseInt(br.readLine());
        
        int[][] wire = new int[N + 1][2];
        int[] dp = new int[N + 1];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int max = 1;

        for(int i=1; i<N+1; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(wire[j][1] < wire[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
        
    }
}