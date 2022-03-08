import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] level = new int[N];
        for(int i=0; i<N; i++){
          level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        Double num = N * 0.15;
        int num_int = (int)Math.round(num);


        int sum = 0;

        for(int i = num_int; i<N-num_int; i++){
          sum = sum + level[i];  
        }

        double ans_double = (double)sum / (double)(N - num_int*2);

        int ans = (int)Math.round(ans_double);

        System.out.println(ans);

        

        
        
    }
}