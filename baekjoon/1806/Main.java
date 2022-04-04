import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i+1] = Integer.parseInt(st.nextToken());
        }

        int end = 0; 
        int sum = 0;
        int ans = N + 1;

        for(int start = 1; start < N+1; start++){
            sum = sum - arr[start - 1];

            while(end + 1 <= N && sum < S){
                end++;
                sum = sum + arr[end];
            }

            if(sum >= S){
                ans = Math.min(ans, end - start + 1);
            }

            if(ans == N+1){
                ans = 0;
            }

            
        }

        System.out.println(ans);
        



    }
}

