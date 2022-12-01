import java.io.*;
import java.util.*;

public class Main {
    final static int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N + 1];

        if(N <= 6) {
            System.out.println(N);
            return;
        } else if(N == 7) {
            System.out.println(9);
            return;
        }

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;
        arr[6] = 6;
        arr[7] = 9;

        for(int i=8; i<N+1; i++) {
            for(int j=3; i-j>0; j++) {
                arr[i] = Math.max(arr[i], (j-1)*arr[i-j]);
            }
        }

        System.out.println(arr[N]);
        
    }
}