import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i=0; i<P; i++){
            st =  new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();

            if(cmd.equals("W")){
                hm.put(name, W);                
            }else if(cmd.equals("L")){
                hm.put(name, -L);
            }
        }

        int score = 0;
        boolean chk = false;

        for(int i=0; i<N; i++){
            String name = br.readLine();
            if(hm.containsKey(name)){
                score = score + hm.get(name);
                if(score < 0 ){
                    score = 0;
                }
            }else{
                score = score - L;
                if(score < 0 ){
                    score = 0;
                }
            }
            if(score >= G){
                chk = true;
            }
        }

        if(chk){
            System.out.println("I AM NOT IRONMAN!!");
        }else{
            System.out.println("I AM IRONMAN!!");
        }


    }

}
