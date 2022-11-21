import java.io.*;
import java.util.*;
 
public class Main {

    static final int INF = 987654321;
    static int[][] flow;
    static int[][] capacity;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        flow = new int[N + 1][N + 1];
        capacity = new int[N + 1][N + 1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            capacity[a][b] = 1;
            // capacity[b][a] = 1;
        }

        
        int total = 0;
        int[] parent = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();

        while(true) {
            Arrays.fill(parent, -1);

            q = new LinkedList<>();
            q.add(1);

            while(!q.isEmpty() && parent[2] == - 1) {
                int cur = q.poll();

                for(int i=1; i<N + 1; i++) {
                    if(capacity[cur][i] - flow[cur][i] > 0 && parent[i] == -1) {
                        q.add(i);
                        parent[i] = cur;
                    }
                }
            }

            if(parent[2] == -1) break;

            int outFlow = INF;

            for(int i=2; i!=1; i=parent[i]) {
                outFlow = Math.min(capacity[parent[i]][i] - flow[parent[i]][i], outFlow);
            }

            for(int i=2; i!=1; i=parent[i]) {
                flow[parent[i]][i] += outFlow;
                flow[i][parent[i]] -= outFlow;
            }

            total += outFlow;
            
        }

        
        System.out.println(total);
        

    }
}