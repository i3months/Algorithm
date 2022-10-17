import java.io.*;
import java.util.*;
 
public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int[] weight;
    static int[][] dp;
    static int[] arr;
    static ArrayList<Integer> a = new ArrayList<>();
    static int res;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = 1 << (N + 1);
        arr = new int[M];

        for(int i=2; i< M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(res);
    }

    static int dfs(int cur){
        if(cur * 2 >= M){
            res += arr[cur];
            return arr[cur];
        }

        if(cur * 2 < M){
            int left = dfs(cur * 2);
            int right = dfs(cur * 2 + 1);

            res += arr[cur] + Math.abs(left - right);
            arr[cur] += Math.max(left, right);

            return arr[cur];
        }

        return 0;
    }
}    