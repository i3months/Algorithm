import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 1;

        while(true){
            String str1 = br.readLine();
            String str2 = br.readLine();

            if(str1.equals("END") && str2.equals("END")){
                break;
            }

            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();

            for(int i=0; i<str1.length(); i++){
                char tmp1 = str1.charAt(i);
                if(hm1.containsKey(tmp1)){
                    hm1.put(tmp1, hm1.get(tmp1) + 1);
                }else{
                    hm1.put(tmp1, 1);
                }
            }

            for(int i=0; i<str2.length(); i++){
                char tmp1 = str2.charAt(i);
                if(hm2.containsKey(tmp1)){
                    hm2.put(tmp1, hm2.get(tmp1) + 1);
                }else{
                    hm2.put(tmp1, 1);
                }
            }


            ArrayList<Character> list = new ArrayList<>(hm1.keySet());

            boolean chk = true;

            for(int i=0; i<list.size(); i++){
                if(hm1.get(list.get(i)) != hm2.get(list.get(i))){
                    chk = false;
                }
            }

            if(chk){
                System.out.printf("Case %d: same\n", cnt);
            }else{
                System.out.printf("Case %d: different\n", cnt);
            }

            cnt++;

            
            


        }
        
    
    }
}