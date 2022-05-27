import java.util.*;
import java.io.*;

public class Main {

    static int N;        

    static int[][] map;
    static boolean[] visit;   
    
    static StringBuilder sb = new StringBuilder();
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
            
        map = new int[N+1][N+1];
        
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<N+1; i++){
            bfs(i);
        }

        System.out.println(sb);

        
        

    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        visit = new boolean[N+1];        
        q.add(x);

        //System.out.println(visit.length);
        
        visit[x] = false;

        while(!q.isEmpty()){
            int tmp = q.poll();

            for(int i=1; i<N+1; i++){
                if(map[tmp][i] == 0){
                    continue;
                }
                if(visit[i]){
                    continue;
                }

                q.add(i);
                visit[i] = true;
            }
            
        }

        for(int i=1; i<N+1; i++){
            if(visit[i]){
                sb.append(1 + " ");
            }else{
                sb.append(0 + " ");
            }
        }
        sb.append("\n");


    }
}