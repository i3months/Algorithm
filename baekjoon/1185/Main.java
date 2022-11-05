import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    static int INF = 987654321;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // int[][] cost_map = new int[N + 1][N + 1];

        parent = new int[N + 1];
        int[] cost = new int[N + 1];

        int min = INF;

        for(int i=1; i<N+1; i++){
            cost[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, cost[i]);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // cost_map[a][b] = c;
            // cost_map[b][a] = c;

            list.add(new Edge(a, b, c*2 + cost[a] + cost[b]));            
        }

        Collections.sort(list);        

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        int ans = 0;

        ArrayList<Integer>[] list2 = new ArrayList[N + 1];
        for(int i=1; i<N+1; i++) list2[i] = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                ans += cur.weight;
                union(cur.start, cur.end);
                // System.out.print("union : ");
                // System.out.println(cur.start + " " + cur.end);

                list2[cur.start].add(cur.end);
                list2[cur.end].add(cur.start);
            }                    
        }
        
        

        System.out.println(ans + min);

            
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