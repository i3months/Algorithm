import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();    
    static int[] parent;    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        // 1 : 최선
        // 2 : 최악

        for(int i=0; i<M+1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            list.add(new Edge(a,b,c));
        }

        Collections.sort(list);        

        for(int i=0; i<N+1; i++){
            parent[i] = i;            
        }

        int ans = 0;        

        for(int i=0; i<M+1; i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                if(cur.weight == 0) ans++;
                // ans += cur.weight;
                union(cur.start, cur.end);
            }                    
        }

        ans = ans * ans;

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<N+1; i++){
            parent[i] = i;            
        }

        int ans2 = 0;        

        for(int i=0; i<M+1; i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                if(cur.weight == 0) ans2++;
                // ans2 += cur.weight;
                union(cur.start, cur.end);
            }                    
        }

        // System.out.println(ans2);

        ans -= (ans2*ans2);


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

    public int compareTo(Edge o2){
        return weight > o2.weight ? 1 : -1;
    }
}