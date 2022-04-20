import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Hashtable<String, String> ht = new Hashtable<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ht.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<M; i++){
            String str = br.readLine();
            System.out.println(ht.get(str));
        }

    }
}