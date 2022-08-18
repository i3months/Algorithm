import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int N, K;
    static int[] kit;
    static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    static boolean chk = false;

    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kit = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }

        bt(0,500);

        System.out.println(ans);
        

    }
    static void bt(int depth, int weight){
        if(depth == N){
            if(weight >= 500){
                ans++;
            }         

            return;
        }


        for(int i=0; i<N; i++){
            int curWeight = weight - K + kit[i];     
            if(!visit[i] && curWeight >= 500){
                visit[i] = true;                                           
                bt(depth + 1, curWeight);                
                visit[i] = false;
            }
        }

    }
}