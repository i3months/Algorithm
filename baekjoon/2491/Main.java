import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                            

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N + 1];
        int[] dp2 = new int[N + 1];

        int max = -1;

        for(int i=1; i<N + 1; i++){
            dp1[i] = 1;

            if(arr[i-1] <= arr[i]){
                dp1[i] = dp1[i-1] + 1;
            }

            max = Math.max(max, dp1[i]);
        }

        
        for(int i=1; i<N+1; i++){
            dp2[i] = 1;
            
            if(arr[i-1] >= arr[i]){
                dp2[i] = dp2[i-1] + 1;
            }

            max = Math.max(max, dp2[i]);
        }


        System.out.println(max);
       
    }
}