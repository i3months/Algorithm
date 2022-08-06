import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int root;
    static ArrayList<Integer>[] list;
    static int N;
    static boolean visit[];

    static int[] arr;

    static StringBuilder sb = new StringBuilder();  
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        list = new ArrayList[N + 1];

        visit = new boolean[N + 1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N+1; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == -1){
                root = i;
                continue;
            }

            list[i].add(tmp);
            list[tmp].add(i);
        }        
        
        dfs(root);

        // System.out.println();

        for(int i=1; i<N+1; i++){
            System.out.println(arr[i]);
        }
        
    }

    static void dfs(int node){

        visit[node] = true;

        arr[node] = cnt;

        // System.out.print(node + "->");
        cnt++;

        for(int k : list[node]){
            if(!visit[k]){
                dfs(k);             
                cnt--;   
            }            
        }

    }
}