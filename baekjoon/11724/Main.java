import java.util.*;
import java.io.*;

public class Main {

    static int N;    
    static int M;
        
    static boolean[] visit;    
    static int cnt;
    
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

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

        int ans = 0;

        for(int i=1; i<N+1; i++){
            if(visit[i]){
                continue;
            }
            dfs(i);
            //System.out.println();
            ans++;
        }

        System.out.println(ans);
    }

    static void dfs(int x){
        visit[x] = true;
        //System.out.print(x + " ");

        for(int y : list[x]){
            if(visit[y]){
                continue;
            }
            dfs(y);
        }

    }
}