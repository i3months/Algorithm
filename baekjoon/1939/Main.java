import java.io.*;
import java.util.*;
 
public class Main {

    static int INF = 987654321;
    static int N, M;
    static ArrayList<Edge>[] list;    
    static int L, R;
    static boolean[] visit;

    static int start, fin;    

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())   ;
            int c = Integer.parseInt(st.nextToken());
            
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));

            R = Math.max(R, c);
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        fin = Integer.parseInt(st.nextToken());

        // BinarySearch();

        System.out.println(BinarySearch());

    }

    static int BinarySearch(){

        int ans = -1;

        while(L <= R){
            visit = new boolean[N + 1];

            int mid = (L + R) / 2;
            visit[start] = true;
            
            Queue<Integer> q = new LinkedList<>();
            q.add(start);

            while(!q.isEmpty()){
                int cur = q.poll();

                for(Edge k : list[cur]){
                    if(visit[k.dest]) continue;
                    if(k.weight < mid) continue;

                    visit[k.dest] = true;
                    q.add(k.dest);
                }
            }
            

            if(visit[fin]){
                L = mid + 1;
                ans = mid;
            }else{
                R = mid - 1;
            }
        }

        return ans;
    }
    
}

class Edge{
    int dest, weight;

    Edge(int a, int b){
        dest = a;
        weight = b;
    }
}