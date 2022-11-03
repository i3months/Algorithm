import java.io.*;
import java.util.*;
 
public class Main {

    static StringBuilder sb = new StringBuilder();
    static int INF = 987654321;
    
    static int N, M;
    static int K;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i=1; i<M + 1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, i));            
        }

        Collections.sort(list);        

        for(int i=0; i<K; i++){
            sb.append(kruskal() + " ");
        }

        System.out.println(sb);

            
    }

    static int kruskal(){
        
        for(int i=1; i<N+1; i++) parent[i] = i;
        
        int ans = 0;

        ArrayList<Integer>[] check_mst = new ArrayList[N + 1];
        for(int i=0; i<N+1; i++) check_mst[i] = new ArrayList<>();

        Edge to_delete = new Edge(0, 0, INF);

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);
            
            int start = find(cur.start);
            int end = find(cur.end);

            if(!SameParent(start, end)){
                union(cur.start, cur.end);
                ans += cur.weight;

                check_mst[cur.start].add(cur.end);
                check_mst[cur.end].add(cur.start);

                if(to_delete.weight > cur.weight){
                    to_delete = cur;
                }
            }
        }

        list.remove(to_delete);

        boolean[] check_mst_visit = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check_mst_visit[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int k : check_mst[cur]){
                if(check_mst_visit[k]) continue;
                check_mst_visit[k] = true;
                
                q.add(k);
            }
        }
        

        for(int i=1; i<N+1; i++){
            if(!check_mst_visit[i]){
                return 0;
            }
        }

        return ans;
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

    static boolean SameParent(int a, int b){
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