import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        answer = BinarySearch(citations);                    
        
        return answer;
    }
    
    static int BinarySearch(int[] arr){
        int L = 0;
        int R = arr[arr.length - 1];
        int ans = 0;
        
        while(L <= R){
            int mid = (L + R) / 2;
            if(check(mid, arr)){
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
            
        }
        
        return ans;
        
        
        
    }
    
    static boolean check(int k, int[] arr){
        int cnt = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] >= k){
                cnt++;
            }
        }
        
        return cnt >= k;
    }
}