import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();    
    static int[] parent;    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {

            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            parent = new int[R*C+1];

            for(int i=0; i<R*C+1; i++) parent[i] = i;

            int idx = 0;

            for(int i=0; i<R; i++) {
                idx++;
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C-1; j++) {
                    int a = Integer.parseInt(st.nextToken());
                    
                    list.add(new Edge(idx, idx+1, a));
                    idx++;
                }
            }

            idx = 0;

            for(int i=0; i<R-1; i++) {
                idx++;
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++) {
                    int a = Integer.parseInt(st.nextToken());

                    list.add(new Edge(idx, idx+C, a));
                    if(j != C - 1) idx++;
                }
            }

            // 입력 끝났고 이제 크루스칼 돌리면 답..

            Collections.sort(list);        

            int ans = 0;                        

            for(int i=0; i<list.size(); i++){
                Edge cur = list.get(i);

                int s = cur.start;
                int e = cur.end;

                int start = find(cur.start);
                int end = find(cur.end);

                if(!sameParent(start, end)){
                    ans += cur.weight;
                    // minCost += cur.weight;
                    // additional++;
                    union(cur.start, cur.end);
                    // trace.add(new Pair(s, e));
                }                    
            }

            System.out.println(ans);
            
        }
        System.exit(0);

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for(int i=0; i<N+1; i++){
            parent[i] = i;            
        }

        int minCost = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }


        int[][] matrix = new int[N+1][N+1];

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {

                if(i == 1) continue;
                if(j == 1) continue;

                // if(i < j) continue;

                int val = matrix[i][j];

                if(val > 0) {
                    list.add(new Edge(i, j, val));
                }
                
            }
        }

        Collections.sort(list);        

        int ans = 0;        
        int additional = 0;

        // System.out.println(minCost);

        ArrayList<Pair> trace = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int s = cur.start;
            int e = cur.end;

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){                
                minCost += cur.weight;
                additional++;
                union(cur.start, cur.end);
                trace.add(new Pair(s, e));
            }                    
        }


        System.out.println(minCost + " " + additional);
        for(Pair k : trace) {
            System.out.println(k.a + " " + k.b);
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
        if(weight > o2.weight) {
            return 1;
        } else if(weight < o2.weight) {
            return -1;
        }else {
            return 0;
        }
        // return weight > o2.weight ? 1 : -1;
    }
}

class Pair {
    int a, b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}