import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        int N = Integer.parseInt(br.readLine());
        
        Hashtable<String, Integer> ht = new Hashtable<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(ht.containsKey(str)){
                ht.put(str, ht.get(str) + 1);
            }else{
                ht.put(str, 1);
            }
        }

        int max = 0;
        String ans = "";

        for(String key : ht.keySet()){
            int val = ht.get(key);
            if(max == val && ans.compareTo(key) > 0){
                ans = key;
                max = val;
            }else if (max < val){
                ans = key;
                max = val;
            }
        }

        System.out.println(ans);
    }
}