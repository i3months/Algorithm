import java.util.*;
import java.io.*;    
public class Main {  
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();

        while(st.hasMoreTokens()){
            int key = Integer.parseInt(st.nextToken());
            if(hm.containsKey(key)){
                hm.put(key, hm.get(key)+1);
            }else{
                hm.put(key, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int key = Integer.parseInt(st.nextToken());

            if(!hm.containsKey(key)){
                sb.append("0 ");                
            }else{
                sb.append(hm.get(key) + " ");                
            }
            
        }
        
        System.out.println(sb);
        
    }   
}
