import java.io.*;
import java.util.*;
 
public class Main {
    static int[][] dp;
    static int N;    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        int TC = Integer.parseInt(br.readLine());

        dp = new int[999][17];
        for(int i=0; i<999; i++) Arrays.fill(dp[i], -1);

        

        while(TC-- > 0) {
            N = Integer.parseInt(br.readLine());            

            System.out.println(solve(N, 0));
            
        }
    
    }
    static int solve(int cur, int state) {
        if(cur < 0) return 0;
        if(cur == 0) {
            if(state == 0) return 1;
            else return 0;
        }
        if(dp[cur][state] != -1) return dp[cur][state];
        
        if(state == 0) dp[cur][state] = solve(cur-1, 0) + solve(cur-2, 0) + solve(cur-1, 3) + solve(cur-1, 9) + solve(cur-1, 12);
        else if(state == 3) dp[cur][state] = solve(cur-1, 0) + solve(cur-1, 12);
        else if(state == 6) dp[cur][state] = solve(cur-1, 9);
        else if(state == 9) dp[cur][state] = solve(cur-1, 0) + solve(cur-1, 6);
        else if(state == 12) dp[cur][state] = solve(cur-1, 0) + solve(cur-1, 3);

        return dp[cur][state];

    }
}