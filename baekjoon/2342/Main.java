import java.io.*;
import java.util.*;

public class Main {    
    static final int INF = 987654321;  

    static int N;
    static int[] map;
    static int[][][] dp;

    static boolean flag = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = 0;
        map = new int[100_001];        

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;

            N++;
            map[N] = num;            
        }

        dp = new int[100_001][5][5];

        System.out.println(solve(1,0,0));
        

    }
    
    static int solve(int turn, int left, int right) {
        if(turn == N + 1) return 0;
        if(dp[turn][left][right] != 0) return dp[turn][left][right];

        dp[turn][left][right] = Math.min(solve(turn+1, map[turn], right) + move(left, map[turn]), solve(turn+1, left, map[turn]) + move(right, map[turn]));
        return dp[turn][left][right];
    }

    static int move(int from, int to){
        if(from==to) return 1;
        
        switch(from){
            case 0: return 2;
            case 1: return to==3 ? 4 : 3;
            case 2: return to==4 ? 4 : 3;
            case 3: return to==1 ? 4 : 3;
            case 4: return to==2 ? 4 : 3;
            default: return -1;
        }
    }
}