import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int target = M * K;
        int cnt = 0;
        int sum = 0;
        for(int i = N-1; i>=0; i--){
            sum = sum + arr[i];
            cnt++;
            if(sum >= target){
                break;
            }
        }

        if(sum >= target){
            System.out.println(cnt);
        }else{
            System.out.println("STRESS");
        }
        


        
    }
}