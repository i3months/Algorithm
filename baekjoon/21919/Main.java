import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = -1;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        boolean[] prime = new boolean[max + 1];

        prime[1] = true; 

        for(int i=2; i * i < max + 1; i++){
            if(prime[i]){
                continue;
            }
            for(int j=i * 2; j < max + 1; j+=i){
                prime[j] = true;
            }
        }

        long ans = 1;

        for(int i=0; i<N;i ++){
            if(prime[arr[i]]){
                continue;
            }
            ans *= arr[i];
            prime[arr[i]] = true;
        }

        System.out.println(ans == 1 ? -1 : ans);
        
    }
}