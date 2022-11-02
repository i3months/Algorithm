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

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Edge(a, b, c));            
        }

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            list.add(new Edge(0, i, cost[i]));
        }        

        Collections.sort(list);        

        for(int i=0; i<N+1; i++){
            parent[i] = i;
        }
        int ans = 0;

        for(int i=0; i<list.size(); i++){
            Edge cur = list.get(i);

            int start = find(cur.start);
            int end = find(cur.end);

            if(!sameParent(start, end)){
                ans += cur.weight;
                union(cur.start, cur.end);
            }
        }

        // PickNumber(1, 0);

        System.out.println(ans);

            
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

    static void PickNumber(int idx, int cnt){
        if(cnt >= 1){            

            ArrayList<Integer>[] traverse = new ArrayList[1000];
            for(int i=0; i<1000; i++) traverse[i] = new ArrayList<>();

            boolean[] traverse_visit = new boolean[N + 1];

            int ans = 0;

            for(int i=1; i<N+1; i++){
                parent[i] = i;
            }

            // ArrayList<Edge> list2 = new ArrayList<>();

            // for(Edge k : list){
            //     list2.add(k);
            // }

            int before = -1;

            for(int i=1; i<N+1; i++){
                if(select[i]){         
                    if(before == -1){
                        before = i;
                    }else{
                        union(before, i);
                        before = i;
                    }                      

                    ans += cost[i];
                    // list2.add(new Edge(i + 100, i, cost[i]));                    
                    // union(i + 100, i);

                    traverse_visit[i] = true;
                } 
            }
            

            if(cnt == N){                        
                min = Math.min(min, ans);     
                // System.out.print("predetermined "+ ans + " /");           
            }            
                    
            Collections.sort(list);

            for(int i=1; i<N+1; i++){
                if(select[i]){
                    // System.out.print(i + " ");
                }
            }            
            
            for(int i=0; i<list.size(); i++){
                Edge cur = list.get(i);
    
                int start = find(cur.start);
                int end = find(cur.end);
    
                if(!sameParent(start, end)){
                    ans += cur.weight;

                    // System.out.print("weight : " + cur.weight + " ");
                    // System.out.print("union : " + cur.start + " " + cur.end + " ");
                                        
                    union(cur.start, cur.end);                  

                    traverse[cur.start].add(cur.end);
                    traverse[cur.end].add(cur.start);
                    
                    // traverse_visit[start] = true;
                    // traverse_visit[end] = true;
                }                    
            }

            boolean flag = false;

            int start = 0;

            for(int i=1; i<N+1; i++){
                if(!traverse_visit[i]){
                    start = i;
                    Queue<Integer> q = new LinkedList<>();
                    boolean[] visit = new boolean[N + 1];
                    q.add(start);
                    visit[start] = true;

                    boolean flag2 = false;

                    while(!q.isEmpty()){
                        int cur = q.poll();

                        for(int k : traverse[cur]){
                            if(visit[k]) continue;
                            if(traverse_visit[k]) flag2 = true;
                            visit[k] = true;
                            q.add(k);
                        }
                    }

                    if(!flag2){
                        flag = true;
                    }
                    
                    
                }
            }
            
            

            
            
            if(!flag){
                min = Math.min(min, ans);                                    
                // System.out.println("ans is " + ans);   
            }else{
                // System.out.println("not satisfied");
            }            
            
        }

        for(int i=idx; i<N+1; i++){
            if(select[i]) continue;

            select[i] = true;
            PickNumber(i, cnt + 1);
            select[i] = false;     
        }
        
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
        // return weight > o2.weight ? 1 : -1;
        if(weight > o2.weight){
            return 1;
        }else if(weight < o2.weight){
            return -1;
        }else{
            return 0;
        }
    }    
}