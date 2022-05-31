import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[100001];

            for(int j = 2; j * j <= N; j++){
                if(N % j == 0){
                    N /= j;
                    arr[j]++;
                    j--;
                }
            }

            if(N != 1) {
                arr[N]++;
            }

            for(int j = 1; j <= 100000; j++){
                if(arr[j] != 0){
                    sb.append(j + " " + arr[j] + "\n");                    
                }
            }
        }
        System.out.println(sb);
    }
}