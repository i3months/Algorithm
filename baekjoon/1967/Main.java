import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static ArrayList<Node> list[];
    static int N;
    static int max_weight, max_idx;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                           
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        visit[1] = true;
        dfs(1,0);

        visit = new boolean[N+1];
        visit[max_idx] = true;
        dfs(max_idx, 0);

        System.out.println(max_weight);                

    }

    static void dfs(int idx, int weight){
        if(max_weight < weight){
            max_weight = weight;
            max_idx = idx;
        }

        for(Node k : list[idx]){
            if(!visit[k.idx]){
                visit[k.idx] = true;
                dfs(k.idx, weight + k.weight);
            }
        }
    }
}


class Node{
    int idx, weight;
    Node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}