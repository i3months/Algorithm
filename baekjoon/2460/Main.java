import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] out = new int[10];
        int[] in = new int[10];

        StringTokenizer st;
        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());
            out[i] = Integer.parseInt(st.nextToken());
            in[i] = Integer.parseInt(st.nextToken());
        }

        int max = -out[0] + in[0];
        int compare = 0;

        for(int i=0; i<10; i++){
            compare = compare -out[i] + in[i];

            if(max < compare){
                max = compare;
            }        

        }

        System.out.println(max);


    }
}