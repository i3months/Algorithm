import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = 0;

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            if(num == 1){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                a--;

                arr[(a + start) % N ] += b;
            }

            if(num == 2){
                int a = Integer.parseInt(st.nextToken());
                start = (start + N - a) % N;
            }

            if(num == 3){
                int a = Integer.parseInt(st.nextToken());
                start = (start + a) % N;
            }            
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            sb.append(arr[(start + i) % N] + " ");
        }

        System.out.println(sb);

    }
}