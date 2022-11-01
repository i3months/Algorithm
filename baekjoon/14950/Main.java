import java.io.*;
import java.util.*;
 
public class Main {
    
    static int INF = 987654321;
    static int N, M;
    static int K;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;
    static int[] cost;
    

    static int min = INF;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];                                   

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, c));            
        }

        Collections.sort(list);       

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }
        
        int ans = 0;        

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                union(cur.start, cur.end);

                ans += cur.weight;
                // node_list[cur.start].add(new Node(cur.end, cur.weight));
                // node_list[cur.end].add(new Node(cur.start, cur.weight));
            }
        }

        // System.out.println(ans);

        for(int i=3; i<N+1; i++){
            ans += (i - 2) * K;
        }

        System.out.println(ans);



            
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){            
            parent[b] = a;
        }
    }

    static boolean sameParent(int a, int b){
        a = find(a);
        b = find(b);

        return a == b;
    }

}

class Edge implements Comparable<Edge>{
    int start, end, weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Edge o2){
        return weight > o2.weight ? 1 : -1;
    }    
}

class Node{
    int dest, cost;
    Node(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}