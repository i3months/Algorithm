import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Map<String, Integer> list = new HashMap<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(list.containsKey(str)){
                list.put(str, list.get(str)+1);
            }else{
                list.put(str, 1);
            }
        }

        for(int i=0; i<N-1; i++){
            String str = br.readLine();
            if(list.get(str) >= 2){
                list.put(str, list.get(str) - 1);
            }else if(list.get(str) == 1){
                list.remove(str);
            }
        }        
        

        for(String key : list.keySet()){
            if(list.get(key) != 0){
                System.out.println(key);
                break;
            }
        }

    }
}