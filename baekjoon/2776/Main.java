import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<T; i++){
            hs.clear();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                hs.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(hs.contains(tmp)){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }
        }

        System.out.println(sb);


        
        
    }
}
