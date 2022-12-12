import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;
    static ArrayList<Edge> list = new ArrayList<>();    
    static int[] parent;    

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC1 = Integer.parseInt(br.readLine());

        while(TC1-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int NN = Integer.parseInt(st.nextToken());
            int MM = Integer.parseInt(st.nextToken());

            parent = new int[MM + 1];
            for(int i=0; i<MM+1; i++) parent[i] = i;

            list = new ArrayList<>();
            ArrayList<Pair> list2 = new ArrayList<>();

            for(int i=1; i<MM+1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list2.add(new Pair(a, b));
            }

            for(int i=0; i<MM; i++) {
                for(int j=i+1; j<MM; j++) {
                    
                    int a1 = list2.get(i).a;
                    int b1 = list2.get(i).b;
                    int c1 = list2.get(j).a;
                    int d1 = list2.get(j).b;

                    double val = Math.sqrt(Math.pow(a1-c1, 2) + Math.pow(b1-d1, 2));

                    list.add(new Edge(i, j, val));                                    
                    list.add(new Edge(j, i, val));                
                }
            }

            Collections.sort(list);

            ArrayList<Double> list3 = new ArrayList<>();

            for(int j=0; j<list.size(); j++){
                Edge cur = list.get(j);

                int start = find(cur.start);
                int end = find(cur.end);

                if(!sameParent(start, end)){
                    list3.add(cur.weight);                        
                    union(cur.start, cur.end);
                }                    
            }

            // System.out.println(Math.round(list3.get(list3.size() - NN) * 100.0) / 100.0);
            System.out.printf("%.2f\n", list3.get(list3.size() - NN));



        }

        System.exit(0);
        
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            pq.add(Integer.parseInt(st1.nextToken()));       
        }

        int aa = 0;
        while(true) {
            if(pq.size() <= 1) break;

            int a = pq.poll()-1;
            int b = pq.poll()-1;

            // System.out.println(a + " " + b);

            if(a != 0) pq.add(a);
            if(b != 0) pq.add(b);

            aa++;
            
        }

        if(!pq.isEmpty()) aa += pq.poll();

        if(aa >= 1441) System.out.println(-1);
        else System.out.println(aa);

        System.exit(0);

        
        
        int TC = Integer.parseInt(br.readLine());

        loop1 : while(TC-- > 0) {

            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];

            for(int i=0; i<N+1; i++) parent[i] = i;

            for(int i=1; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new Edge(i, a, b));
                list.add(new Edge(a, i, b));
            }

            long ans2 = 0;

            for(int i=0; i<M; i++) {    
                for(int q=0; q<N+1; q++) parent[q] = q;

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.add(new Edge(a, b, c));
                list.add(new Edge(b, a, c));

                Collections.sort(list);        

                long ans = 0;                        

                for(int j=0; j<list.size(); j++){
                    Edge cur = list.get(j);

                    int start = find(cur.start);
                    int end = find(cur.end);

                    if(!sameParent(start, end)){
                        ans += cur.weight;                            
                        union(cur.start, cur.end);
                    }                    
                }

                ans2 = (ans2 ^ ans);
            }
            
            

            sb.append(ans2 + "\n");
            // System.out.println(ans2);
            
        }

        System.out.println(sb);
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
    int start, end;
    double weight;

    Edge(int start, int end, double weight){
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
    }
}

class Pair {
    int a, b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}