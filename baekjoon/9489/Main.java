import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if(N == 0 && K == 0){
                break;
            }

            int[] arr = new int[N+1];
            int[] parent = new int[N+1];

            int idx = -1;
            int target = 0;

            parent[0] = -1;
            arr[0] = -1;

            st = new StringTokenizer(br.readLine());

            for(int i=1; i<N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());

                if(arr[i] == K){
                    target = i;    
                }

                if(arr[i] != arr[i - 1] + 1){
                    idx++;
                }

                parent[i] = idx;
            }

            int ans = 0;

            for(int i=1; i<N+1; i++){
                if(parent[i] != parent[target] && parent[parent[i]] == parent[parent[target]]){
                    ans++;
                }
            }

            sb.append(ans + "\n");

        }

        System.out.println(sb);


    }
    
}

