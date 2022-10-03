import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String k : completion){
            hm.put(k, hm.getOrDefault(k, 0) + 1);
        }
        
        for(String k : participant){
            if(hm.get(k) == null){
                answer = k;
                break;
            }
            
            hm.put(k, hm.get(k) - 1);
            if(hm.get(k) == -1){
                answer = k;
                break;
            }
        }
        
        
        return answer;
    }
}