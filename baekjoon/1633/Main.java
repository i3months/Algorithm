import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();

    static int[] white = new int[1001];
    static int[] black = new int[1001];
    static int[][][] dp = new int[1001][16][16];
    
    static int idx, cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                            

        String str = "";        

        while((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str);
        
            white[idx] = Integer.parseInt(st.nextToken());
            black[idx] = Integer.parseInt(st.nextToken());            

            idx++;
            
            int v = idx - 1;
            if(white[v] == 0){
                break;
            }
        }
        idx--;

        System.out.println(solve(0,0,0));
        System.out.println(cnt);
        
    }

    static int solve(int w, int b, int cur){
        if(cur == idx){
            return 0;
        }

        if(w == 4 && b == 4){
            return 0;
        }

        int val = dp[cur][w][b];

        if(val != 0){
            return val;
        }


        // w고르기
        if(w < 4){
            val = Math.max(val, solve(w + 1, b, cur + 1) + white[cur]);
        }

        // b고르기
        if(b < 4){
            val = Math.max(val, solve(w, b + 1, cur + 1) + black[cur]);
        }

        // 안고르기
        val = Math.max(val, solve(w, b, cur + 1));

        dp[cur][w][b] = val;

        cnt++;
        return dp[cur][w][b];
        
    }
}