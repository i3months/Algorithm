import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }                     
        
        int degree = N;        

        int x = 1;

        solve(degree, arr, x);
        
    }

    static void solve(int degree, int[] arr, int x){
        int value = arr[0];
        int cost = -1;

        for(int i=1; i<degree + 1; i++){
            value = value * x + arr[i];
            cost += 2;

            if(arr[i] != 0){
                cost += 1 + String.valueOf(arr[i]).length();
            }
        }

        cost++;

        System.out.println(cost);
    }
}