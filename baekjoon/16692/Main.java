import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] customer = new int[C];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<C;i ++){
            customer[i] = Integer.parseInt(st.nextToken())    ;
        }

        int[] casher = new int[N];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<C; i++){
            int min_idx = -1;
            int min_value = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){
                if(casher[j] < min_value){
                    min_value = casher[j];
                    min_idx = j + 1;
                }
            }
            casher[min_idx - 1] += customer[i];
            sb.append(min_idx + " ");
        }

        System.out.println(sb);
        
    }
}