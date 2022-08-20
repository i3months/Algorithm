import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int N;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int query = Integer.parseInt(br.readLine());

        for(int i=0; i<query; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if(T == 2){
                sb.append("yes\n");
            }

            if(T == 1){
                int cnt = 0;
                for(int k : list[K]){
                    cnt++;
                }

                if(cnt >= 2){
                    sb.append("yes\n");
                }else{
                    sb.append("no\n");
                }
            }

        }

        System.out.println(sb);
        
        
        
    }
}