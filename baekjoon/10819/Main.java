import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[] arr;
    static int[] select;
    static boolean[] visit;
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        select = new int[N];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0);

        System.out.println(max);
        
    } 
    
    static void bt(int depth){
        if(depth == N){
            // calculate
            int sum = 0;
            for(int i=0; i<N-1; i++){
                int a1 = select[i];
                int a2 = select[i + 1];

                int tmp = Math.abs(a1 - a2);

                sum += tmp;
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<N; i++){
            
            if(!visit[i]){
                visit[i] = true;
                select[depth] = arr[i];
                bt(depth+1);
                visit[i] = false;
                select[depth] = 0;    
            }
            
        }
    }

}