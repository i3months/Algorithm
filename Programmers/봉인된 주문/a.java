import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        List<String>[] bannedLists = new ArrayList[12];
        
        for (int i=1; i<=11; i++) {
            bannedLists[i] = new ArrayList<>();
        }
        
        for (String s : bans) {
            int len = s.length();
            bannedLists[len].add(s);
        }
        
        for (int i=1; i<=11; i++) Collections.sort(bannedLists[i]);
        
        long[] pow = new long[12];
        pow[0] = 1;
        
        for (int i=1; i<=11; i++) pow[i] = pow[i-1] * 26;
        
        long cumulative = 0;
        int L = -1;
        for (int len = 1; len <= 11; len++) {
            long total = pow[len];
            long bannedCount = bannedLists[len].size();
            long valid = total - bannedCount;
            if (cumulative + valid >= n) {
                L = len;
                break;
            } else {
                cumulative += valid;
            }
        }
               
        long k = n - cumulative;
        
        StringBuilder ans = new StringBuilder();
            
        // 길이는 L, k번째 주문 찾기 
        for (int pos = 0; pos < L; pos++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String prefix = ans.toString() + c;                
                long completions = pow[L - pos - 1];                
                long bannedCount = countBanned(bannedLists[L], prefix);
                long validCount = completions - bannedCount;
                
                if (k > validCount) {
                    k -= validCount;
                } else {
                    ans.append(c);
                    break;
                }
            }
        }
        
        return ans.toString();
    }
        
    private long countBanned(List<String> list, String prefix) {        
        String next = prefix + '{';
        int lower = lowerBound(list, prefix);
        int upper = lowerBound(list, next);
        return upper - lower;
    }
        
    private int lowerBound(List<String> list, String target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).compareTo(target) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
