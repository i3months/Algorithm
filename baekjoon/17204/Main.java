import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            list[i].add(Integer.parseInt(br.readLine()));
        }

        int[] visit = new int[N];
        
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        for(int i=0; i<N; i++){
            visit[i] = -1;
        }

        visit[0] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            
            int next = list[cur].get(0);

            if(next == K){
                System.out.println(visit[cur] + 1);
                return;
            }

            if(visit[next] != -1){
                System.out.println(-1);
                return;
            }

            visit[next] = visit[cur] + 1;
            q.add(next);
        
        }
        
        
        
    }
}