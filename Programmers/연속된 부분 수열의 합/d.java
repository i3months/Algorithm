class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int start = 0, end = 0;
        int sum = sequence[0];
        
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0, bestEnd = 0;
        
        while (start < n && end < n) {
            if (sum < k) { 
                end++;
                if (end < n) {
                    sum += sequence[end];
                }
            } else if (sum > k) { 
                sum -= sequence[start];
                start++;
            } else { 
                int currentLen = end - start + 1;
                
                if (currentLen < bestLen) {
                    bestLen = currentLen;
                    bestStart = start;
                    bestEnd = end;
                }
                
                sum -= sequence[start];
                start++;
            }
        }
        return new int[] {bestStart, bestEnd};
    }
}
