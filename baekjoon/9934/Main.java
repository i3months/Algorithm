import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    static int[] arr;
    static ArrayList<Integer>[] list;
    static int size, height, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        N = Integer.parseInt(br.readLine());

        size = (int)Math.pow(2,N) - 1;
        arr = new int[size];
        list = new ArrayList[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        solve(0, size - 1, 0);

        for(int i=0; i<N; i++){
            for(int k : list[i]){
                System.out.print(k + " ");
            }
            System.out.println();
        }
        


    }

    static void solve(int s, int e, int depth){
        if(depth == N){
            return;
        }

        int mid = (s + e) / 2;

        list[depth].add(arr[mid]);

        solve(s, mid - 1, depth + 1);
        solve(mid + 1, e, depth + 1);

    }
}