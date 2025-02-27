import java.util.*;

class Solution {
    static int MAX = 9999999;
    
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        
        int[][] dp = new int[size+1][m+1];
        
        for(int i=0; i<size+1; i++) Arrays.fill(dp[i], MAX);    
        
        dp[0][0] = 0;
        
        for (int i=1; i<size+1; i++) {
            int aCost = info[i-1][0];
            int bCost = info[i-1][1];
            for (int j=0; j<m; j++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + aCost);
                if (j + bCost < m) dp[i][j+bCost] = Math.min(dp[i][j+bCost], dp[i-1][j]);             
            }
        }
        
        int ans = MAX;
        
        for (int i=0; i<m; i++) {
            ans = Math.min(dp[size][i], ans);    
        }
        
        ans = ans >= n ? -1 : ans;
        
        return ans;
        
        

    }
}