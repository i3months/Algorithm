//MST
import java.io.*;
import java.util.*;
 
public class Main {
    
    static int INF = 987654321;
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;
    static int[] cost;

    static boolean[] select;

    static int min = INF;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        

        parent = new int[N + 1000];       
        cost = new int[N + 1]; 
        select = new boolean[N + 1];        

        // for(int i=1; i<N+1; i++){
        //     cost[i] = Integer.parseInt(st.nextToken());
        //     list.add(new Edge(0, i, cost[i]));
        // }        

        long sum = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sum += c;

            list.add(new Edge(a, b, c));            
        }

        Collections.sort(list);        

        for(int i=0; i<N+1; i++){
            parent[i] = i;
        }

        long ans = 0;

        int aaa = 0;

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                ans += cur.weight;
                union(cur.start, cur.end);
                aaa++;
                if(aaa == N-1) break;
            }
        }        

        System.out.println(aaa == N-1 ? ans : - 1);

            
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
    int start, end;
    long weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Edge o2){
        if(weight > o2.weight) {
            return -1;
        } else if(weight < o2.weight) {
            return 1;
        }else {
            return 0;
        }        
    }
}