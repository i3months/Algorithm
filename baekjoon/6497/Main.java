import java.io.*;
import java.util.*;
 
public class Main {
    
    static int V, E;
    static ArrayList<Edge> list = new ArrayList<>();

    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
                    
        while(true){
            int sum = 0;
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if(V == 0 && E == 0) break;

            parent = new int[300_000];

            for(int i=0; i<E;i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());            
                int c = Integer.parseInt(st.nextToken());

                sum += c;
                
                list.add(new Edge(a,b,c));
            }

            Collections.sort(list);        

            for(int i=1; i<V+1; i++){
                parent[i] = i;
            }

            int ans = 0;

            for(int i=0; i<E; i++){
                Edge cur = list.get(i);

                int start = find(cur.start);
                int end = find(cur.end);

                if(!sameParent(start, end)){
                    ans += cur.weight;
                    union(cur.start, cur.end);
                }                    
            }

            System.out.println(sum - ans);  
        }
        

            
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
        if(weight > o2.weight){
            return 1;
        }else if(weight < o2.weight){
            return -1;
        }else{
            return 0;
        }        
    }
}