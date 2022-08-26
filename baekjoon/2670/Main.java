import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                    

        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N+1];

        for(int i=1; i<N+1; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
   
        arr[0] = 1;
        double max = -1;

        for(int i=1; i<N+1; i++){
            arr[i] = Math.max(arr[i], arr[i-1] * arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.printf("%.3f", max);
        
        
    }
}