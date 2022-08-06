import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        
        for(int i=0; i<K; i++){
            String str = br.readLine();
            int len = str.lastIndexOf(" ") + 1;
            str = str.substring(len);

            // System.out.println(str);
            int total = (len / 4) + 1;
            // System.out.println(total);            

            if(!hm.containsKey(str)){
                hm.put(str, total);
            }else{
                int tmp = hm.get(str);
                if(tmp <= total){
                    hm.put(str, total);
                }
            }            

        }

        int sum = 0;

        for(int k : hm.values()){
            sum += k;    
        }

        if(sum <= N){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }
}