import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static int S, E;
    static ArrayList<Locate>[] list;
    static ArrayList<Edge> list2 = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());        

        parent = new int[N + 1];
        list = new ArrayList[N + 1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Locate(b, c));
            list[b].add(new Locate(a, c));
            // list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }
          

        // for(int i=1; i<N+1; i++){
        //     parent[i] = i;
        // }

        // int ans = 0;

        // for(int i=0; i<M; i++){
        //     Edge cur = list.get(i);

        //     int start = find(cur.start);
        //     int end = find(cur.end);

        //     if(!sameParent(start, end)){
        //         ans += cur.weight;
        //         union(cur.start, cur.end);
        //     }                    
        // }

        // System.out.println(ans);

        int L = 0;
        int R = 100_000_0;
        
        while(L <= R){
            int mid = (L + R) / 2;
            if(bfs(mid)){
                L = mid + 1;
            }else{
                R = mid -1 ;
            }
        }

        System.out.println(R == -1 ? 0 : R);

            
    }

    static boolean bfs(int val){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        q.add(S);
        
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == E) return true;
            
            for(Locate k : list[cur]){
                if(visit[k.dest]) continue;
                if(k.cost < val) continue;
                visit[k.dest] = true;
                q.add(k.dest);
            }
        }

        return false;
    }


    //

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

    public int compareTo(Edge o2){
        return weight > o2.weight ? 1 : -1;
    }
}

class Locate{
    int dest, cost;
    Locate(int a, int b){dest=a;cost=b;}
}