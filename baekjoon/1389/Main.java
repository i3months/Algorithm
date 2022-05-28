import java.util.*;
import java.io.*;

public class Main {

    static int N;        
    static int M;

    static int target1;
    static int target2;

    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visit;   

    static int[] dist;
    
    static StringBuilder sb = new StringBuilder();
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
                
        visit = new boolean[N+1];    
        dist = new int[N+1];    

        int ans = Integer.MAX_VALUE;        

        int idx_ans = 0;

        for(int i=1; i<N+1; i++){
            bfs(i);
            int temp = 0;      

            for(int j=1; j<N+1; j++){
                temp = temp + dist[j];
            }

            if(ans > temp){
                ans = temp;
                idx_ans = i;   
            }            
            
        }
        System.out.println(idx_ans);


        
    }
    static void bfs(int start){
        for(int i=1; i<N+1; i++){
            visit[i] = false;
        }
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<N+1; i++){
            dist[i] = -1;
        }

        dist[start] = 0;
        q.add(start);

        while(!q.isEmpty()){
            int x = q.poll();
            for(int y : list[x]){
                if(visit[y]){
                    continue;
                }
                q.add(y);
                visit[y] = true;
                dist[y] = dist[x] + 1;
            }
        }
    }
}