import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[] pre, in;
    static int TC;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            int N = Integer.parseInt(br.readLine());

            pre = new int[N+1];
            in = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++){
                pre[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<N; i++){
                in[i] = Integer.parseInt(st.nextToken());
            }

            traverse(0,0,N);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void traverse(int root, int start, int end){
        int rootIdx = pre[root];

        for(int i=start; i<end; i++){
            if(in[i] == rootIdx){
                traverse(root + 1, start, i);
                traverse(root + i + 1 - start, i + 1, end);
                sb.append(rootIdx + " ");
            }
        }
    }
    
}

