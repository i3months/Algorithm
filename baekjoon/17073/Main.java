import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int cnt = 0;

        for(int i=2; i<N+1; i++){
            if(list[i].size() == 1){
                cnt ++;
            }
        }

        System.out.println((double)W / (double)cnt );
        
        
        
    }
}