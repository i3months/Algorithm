import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M, C;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        ArrayList<Locate> locate_list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());            

            locate_list.add(new Locate(a, b));            
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i == j) continue;
                
                int cmp1 = locate_list.get(i).r - locate_list.get(j).r;
                cmp1 = cmp1 * cmp1;
                int cmp2 = locate_list.get(i).c - locate_list.get(j).c;
                cmp2 = cmp2 * cmp2;

                if(cmp1 + cmp2 < C) continue;

                list.add(new Edge(i, j, cmp1 + cmp2));
            }
        }

        Collections.sort(list);        

        for(int i=1; i<N+1; i++){
            parent[i] = i;
        }

        int ans = 0;

        ArrayList<Integer>[] list2 = new ArrayList[N + 1];
        for(int i=0; i<N+1; i++) list2[i] = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);            

            if(!sameParent(start, end)){
                ans += cur.weight;
                union(cur.start, cur.end);

                list2[cur.start].add(cur.end);
                list2[cur.end].add(cur.start);
            }                    
        }

        boolean[] visit = new boolean[N];
        visit[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int k : list2[cur]){
                if(visit[k]) continue;
                visit[k]  = true;
                q.add(k);
            }
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(ans);

            
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

class Locate{
    int r, c;
    Locate(int r, int c){
        this.r = r;
        this.c = c;
    }
}