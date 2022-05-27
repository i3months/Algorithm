import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int M;

    static boolean[] visit;

    static ArrayList<Integer>[] list;
    static int cnt = 0;
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N+1];      
        
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);

        for(int i=2; i<N+1; i++){
            if(visit[i]){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();

        q.add(x);
        visit[x] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int y : list[tmp]){
                if(visit[y]){
                    continue;
                }
                q.add(y);
                visit[y] = true;
            }
            
        }
    }
}