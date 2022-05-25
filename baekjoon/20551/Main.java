import java.util.*;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.io.*;

public class Main {

    static int N;
    static int M;

    static int[] arr;
    static int[] query;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        // fix need

        query = new int[M];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            query[i] = Integer.parseInt(br.readLine());

            int ans = -1;

            int L = 0;
            int R = N-1;

            while(L<=R){
                int mid = (L + R) / 2;

                if(arr[mid] == query[i]){
                    ans = mid;
                }

                if(arr[mid] < query[i]){
                    L = mid + 1;
                }else{
                    R = mid - 1;
                }                
            }
            if(ans == -1){
                sb.append(-1 + "\n");
            }else{
                sb.append(ans + "\n");
            }
        }       


        System.out.println(sb);

    }
}