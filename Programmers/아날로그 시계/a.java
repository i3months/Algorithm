class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        int countMinute = 0;
        int kMinMinute = (start * 59 + 3600 - 1) / 3600;
        int kMaxMinute = (end * 59) / 3600;             
        countMinute = kMaxMinute - kMinMinute + 1;
        
        int countHour = 0;
        int kMinHour = (start * 719 + 43200 - 1) / 43200;
        int kMaxHour = (end * 719) / 43200;              
        countHour = kMaxHour - kMinHour + 1;
        
        int countTriple = 0;
        if(start <= 0 && 0 <= end) countTriple++;
        if(start <= 43200 && 43200 <= end) countTriple++;
        
        int answer = countMinute + countHour - countTriple;
        return answer;
    }
}
