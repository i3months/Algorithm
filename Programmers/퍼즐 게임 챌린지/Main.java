class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        return binarySearch(diffs, times, limit);
    }
    
    static int binarySearch(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100_000;
        int mid = 0;
        
        while(start <= end) {
            mid = (start + end) / 2;
            
            if (isValid(diffs, times, limit, mid)) {
                end = mid - 1;                
            }
            else {
                start = mid + 1;
            }
        }
        
        return start;
        
    }
    
    static boolean isValid(int[] diffs, int[] times, long limit, int level) {
        long sum = 0;
        
        for(int i=0; i<diffs.length; i++) {
            if (diffs[i] <= level) {
                sum += times[i];
            }
            else {
                sum += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }
        }
        
        return sum <= limit ? true : false;
    }
}