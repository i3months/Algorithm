import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();

        st=  new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(st.nextToken());
            
            if(hm.containsKey(temp)){
                hm.put(temp, hm.get(temp)+1);
            }else{
                hm.put(temp, 1);
            }

        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int temp = Integer.parseInt(st.nextToken());
            
            if(hm.containsKey(temp)){
                hm.put(temp, hm.get(temp)+1);
            }else{
                hm.put(temp, 1);
            }

        }

        int cnt = 0;
        for(Integer asdf : hm.keySet()){
            if(hm.get(asdf) == 1){
                cnt++;
            }
        }

        System.out.println(cnt);






    }
}