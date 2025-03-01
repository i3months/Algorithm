import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        double position = -1;
        int cnt = 0;
        
        for(int[] target : targets) {
            int start = target[0];
            int end = target[1];
            
            if (start < position && position < end) continue;
            position = end - 0.1;
            cnt++;
            
        }
        
        return cnt;
    }
}