import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());        
        long[] arr = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){            
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long sum = 0;

        for(int i=1; i<N; i++){
            sum += arr[i];
        }
        
        sum = sum + Math.min(sum + 1, arr[N]);
        System.out.println(sum);
        
    }
}