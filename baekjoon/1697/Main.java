import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int K;    
    
    static int[] dist;
    static boolean[] visit;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[200_000];
        visit = new boolean[200_000];

        bfs();
        System.out.println(dist[K]);
        
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(N);
        visit[N] = true;
        dist[N] = 0;

        while(!q.isEmpty()){
            int x = q.poll();

            if(x - 1 >= 0 && !visit[x-1]){
                visit[x-1] = true;
                dist[x-1] = dist[x] + 1;
                q.add(x-1);
            }

            if(x+1 <= 100_000 && !visit[x+1]){
                visit[x+1] = true;
                dist[x+1] = dist[x] + 1;
                q.add(x+1);
            }

            if(x * 2 <= 100_000 && !visit[x*2]){
                visit[x*2] = true;
                dist[x * 2] = dist[x] + 1;
                q.add(x * 2);
            }
        }
    }
}