class Solution {
    
    static int dia;
    static int iron;
    static int stone;
    
    static String[] mineralss;
    
    static int min = 1_000_000;
    
    public int solution(int[] picks, String[] minerals) {
        dia = picks[0];
        iron = picks[1];
        stone = picks[2];
        mineralss = minerals;
        
        solve(0, 0);
        
        return min;
        
    }
    
    void solve(int idx, int sum) {
        if (idx == mineralss.length) {
            min = Math.min(min, sum);
            return;
        }
        
        if (dia == 0 && iron == 0 && stone == 0) {
            min = Math.min(min, sum);
            return;
        }
        
        if (dia > 0) {
            int fatigue = 0;
            for(int i=idx; i<Math.min(idx+5, mineralss.length); i++) {
                fatigue++;
            }
            
            dia--;
            solve(idx + 5, sum + fatigue);
            dia++;
        }
        
        if (iron > 0) {
            int fatigue = 0;
            for(int i=idx; i<Math.min(idx+5, mineralss.length); i++) {
                if (mineralss[i].equals("diamond")) {
                    fatigue += 5;
                }
                else {
                    fatigue++;
                }
            }
            
            iron--;
            solve(idx + 5, sum + fatigue);
            iron++;
        }
        
       if (stone > 0) {
            int fatigue = 0;
            for (int i = idx; i < Math.min(idx + 5, mineralss.length); i++) {
                if (mineralss[i].equals("diamond"))
                    fatigue += 25;
                else if (mineralss[i].equals("iron"))
                    fatigue += 5;
                else
                    fatigue += 1;
            }
            stone--;
            solve(idx + 5, sum + fatigue);
            stone++;
        }
        
    }
}