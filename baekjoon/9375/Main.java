import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            HashMap<String, Integer> hm = new HashMap<>();

            int M = Integer.parseInt(br.readLine());

            for(int j=0; j<M; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                st.nextToken();
                String tmp = st.nextToken();

                if(hm.containsKey(tmp)){
                    hm.put(tmp, hm.get(tmp)+1);
                }else{
                    hm.put(tmp, 1);
                }

                
            }
            
            int ans = 1;

            for(String tk : hm.keySet()){
                ans = ans * (hm.get(tk) +1);    
            }

            ans = ans - 1;
            System.out.println(ans);
            
        }


    }
}