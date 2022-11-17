import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M, K;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;
    static int[] cost;
    static int[] cost2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];                

        st = new StringTokenizer(br.readLine());

        cost = new int[N + 1];
        cost2 = new int[N+1];

        for(int i=1; i<N+1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N+1; i++){
            parent[i] = i;
        }        

        for(int i=1; i<M+1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int start = find(a);
            int end = find(b);                                    

            if(!sameParent(start, end)) {
                union(a, b);
                // cost2[a] = min;                
                // System.out.println(parent[a] + " " + parent[b]);

                // System.out.print("debug : ");
                // for(int aa=1; aa<N+1; aa++) {
                    // System.out.print(parent[aa] + " ");
                // }
                // System.out.println();

            }
        }

        

        int sum = 0;
        for(int i=1; i<N+1; i++) {
            
            int par = find(i);

            if(par != find(0)) {
                sum += cost[par];
                union(0, i);
            }

            // if(find(parent[i]) == 0) {
            //     sum += cost[find(i)];   
            // }            
        }

        if(sum > K) System.out.println("Oh no");
        else System.out.println(sum);
        
            
    }

    static int find(int a){
        if(parent[a] == a){
            return a;
        }

        return parent[a] = find(parent[a]); // 경로압축        
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){            
            if(cost[a] < cost[b]) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
            // parent[a] = b;
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

    @Override
    public boolean equals(Object o2){
        Edge o3 = (Edge)o2;

        if(o3.start == this.start && o3.end == this.end && o3.weight == this.weight){
            return true;
        }

        return false;
    }
    
    @Override
    public int compareTo(Edge o2){
        if(weight > o2.weight){
            return 1;
        }else if(weight == o2.weight){
            return 0;
        }else{
            return -1;
        }
 
    }
}