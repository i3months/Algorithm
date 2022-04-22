import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<M; i++){
            String str = br.readLine();
            hm.put(str, i);
        }
        
        ArrayList<String> list = new ArrayList<>(hm.keySet());

        Collections.sort(list, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(hm.get(o1) > hm.get(o2)){
                    return 1;
                }else if(hm.get(o1) < hm.get(o2)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        if(list.size() <= N){
            N = list.size();
        }

        for(int i=0; i<N; i++){
            System.out.println(list.get(i));
        }




        


    }
}
