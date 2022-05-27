import java.util.*;
import java.io.*;

public class Main {

    static int N;        

    static int[] parent;
    static ArrayList<Integer>[] list;
    static boolean[] visit;   
    
    static StringBuilder sb = new StringBuilder();
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
            
        list = new ArrayList[N+1];
        parent = new int[N+1];
        visit = new boolean[N+1];
        
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }        

        bfs(1);
        
        for(int i=2; i<N+1; i++){
            System.out.println(parent[i]);
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            for(int y : list[x]){
                if(visit[y]){
                    continue;
                }
                
                q.add(y);
                parent[y] = x; // 첫 번째 요소가 부모임
                visit[y] = true;
            }
        }
    }
}