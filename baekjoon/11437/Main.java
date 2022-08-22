import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static int[] parent, depth;
    static ArrayList<Integer>[] list;
    static int N, TC;
    
    static boolean[] findroot;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        // root 는 1
        N = Integer.parseInt(br.readLine());
    
        parent = new int[N+1];
        depth = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        

        for(int i=0; i<N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        init(1,1,0);

        int query = Integer.parseInt(br.readLine());

        for(int i=0; i<query; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a,b) + "\n");
            
        }

        System.out.println(sb);
        

        
    }

    static void init(int cur, int height, int par){
        depth[cur] = height;
        parent[cur] = par;
        for(int k :list[cur]){
            if(k != par){
                init(k, height + 1, cur);
            }
        }
    }

    static int LCA(int a, int b){
        int aH = depth[a];
        int bH = depth[b];
        while(aH > bH){
            a = parent[a];
            aH--;
        }

        while(bH > aH){
            b = parent[b];
            bH--;
        }

        while(a!=b){
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
    
}

