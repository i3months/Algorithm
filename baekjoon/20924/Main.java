import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, root;
    static int pillar, max, gigaNode;
    static boolean[] visit;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));     

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[node1].add(new Node(node2, cost));
            list[node2].add(new Node(node1, cost));
        }

        visit = new boolean[N+1];
        pillarDFS(root, 0);
        branchDFS(gigaNode, 0);

        System.out.println(pillar + " " + max);

    }

    static void pillarDFS(int n, int sum){
        if((list[n].size() >= 2 && n == root) || list[n].size() > 2 || (list[n].size() == 1 && n != root)){
            pillar = sum;
            gigaNode = n;
            return;
        }

        for(Node k : list[n]){
            if(!visit[k.num]){
                visit[k.num] = true;
                pillarDFS(k.num, sum + k.cost);
            }
        }
    }

    static void branchDFS(int n , int sum){
        if(list[n].size() == 1){
            max = Math.max(max, sum);
            return;
        }

        for(Node k : list[n]){
            if(!visit[k.num]){
                visit[n] = true;
                sum += k.cost;
                branchDFS(k.num, sum);
                sum -= k.cost;
                visit[n] = false;
            }
        }
    }
    
}


class Node{
    int num, cost;
    Node(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
}
