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

        TC = Integer.parseInt(br.readLine());
        
        while(TC-- >0){
            N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            depth = new int[N + 1];
            list = new ArrayList[N + 1];
            findroot = new boolean[N + 1];

            Arrays.fill(findroot, true);

            for(int i=0; i<N+1; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i< N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                findroot[b] = false;                
            }

            int idx = 0;

            for(int i=1; i<N+1; i++){
                if(findroot[i]){
                    idx = i;
                    break;
                }
            }

            // continue.....

            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            init(idx, 1, 0);
            System.out.println(LCA(node1,node2));
            
            
        }


    }

    static void init(int cur, int height, int par){
        depth[cur] = height; 
        parent[cur] = par;
        
        for(int k : list[cur]){
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

