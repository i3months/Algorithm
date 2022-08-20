import java.util.*;
import java.io.*;
import java.math.*;

public class Main { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;

        for(int i=0; i<N; i++){
            if(sum + 1 < arr[i]){
                System.out.println(sum + 1);
                return;                
            }

            sum += arr[i];
        }
// asf
        System.out.println(sum + 1);
        
    }
}