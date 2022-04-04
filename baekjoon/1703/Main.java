import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0){
                break;
            }

            int[] arr = new int[N*2];
            
            for(int i=0; i<N*2; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int sum = arr[0] - arr[1];

            for(int i=2; i<N*2 - 1; i=i+2){
                sum = sum * arr[i];
                sum = sum - arr[i+1];
            }

            System.out.println(sum);


        }

    }
}

