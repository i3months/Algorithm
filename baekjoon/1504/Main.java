import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
 
public class Main {

    static int N, E;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visit;
    static int INF = 200_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        dist = new int[N+1];
        visit = new boolean[N+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int cand1 = 0;

        cand1 = cand1 + Dijkstra(1, v1);        
        cand1 = cand1 + Dijkstra(v1, v2);        
        cand1 = cand1 + Dijkstra(v2, N);
        
        int cand2 = 0;

        cand2 = cand2 + Dijkstra(1, v2);
        cand2 = cand2 + Dijkstra(v2, v1);
        cand2 = cand2 + Dijkstra(v1, N);

        System.out.println(Math.min(cand1, cand2));                
        

    }

    static int Dijkstra(int s, int e){
        Arrays.fill(dist, INF);
        Arrays.fill(visit, false);
        dist[s] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(s, 0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            int curNode = tmp.end;
            int curCost = tmp.cost;

            if(!visit[curNode]){
                visit[curNode] = true;

                for(Node nd : list[curNode]){
                    int nextNode = nd.end;
                    int nextCost = nd.cost;                    
                    if(!visit[nextNode] && dist[nextNode] > curCost + nextCost){
                        dist[nextNode] = curCost + nextCost;
                        pq.add(new Node(nextNode, dist[nextNode]));
                    }
                }
            }

        }

        return dist[e];
        
    }
}
 
class Node implements Comparable<Node>{
    int end, cost;
    
    Node(int a, int b){
        end = a;
        b = cost;
    }

    public int compareTo(Node o2){
        if(cost > o2.cost){
            return 1;
        }else{
            return -1;
        }
    }
    
}