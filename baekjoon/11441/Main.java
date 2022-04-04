import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());        

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int arr_sum[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<N; i++){
            if(i == 0){
               arr_sum[i] = arr[i];
            }else{
                arr_sum[i] = arr_sum[i-1] + arr[i];
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            if(start == 1){
                sb.append(arr_sum[end-1]+ "\n");    
            }else{
                sb.append(arr_sum[end-1] - arr_sum[start-2] + "\n");
            }
            
        }

        System.out.println(sb);

    }
}

