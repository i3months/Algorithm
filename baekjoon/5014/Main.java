import java.io.*;
import java.util.*;

public class Main {
    static int F,S,G,U,D;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new boolean[F+1];

        int ans = bfs();

        System.out.println(ans == -1 ? "use the stairs" : ans);

        // for(boolean k : visit){
        //     System.out.print(k + " ");
        // }
        
        
    }

    static int bfs(){
        Queue<Floor> q = new LinkedList<>();

        q.add(new Floor(S, 0));  
        visit[S] = true;      

        while(!q.isEmpty()){
            Floor cur = q.poll();

            if(cur.locate == G){
                return cur.cnt;
            }

            for(int i=0; i<2; i++){
                if(i == 0){                    
                    int next = cur.locate + U;
                    if(next <= F){
                        if(!visit[next]){
                            visit[next] = true;
                            q.add(new Floor(next, cur.cnt + 1));
                        }
                    }                    
                }

                if(i == 1){
                    int next = cur.locate - D;
                    if(next > 0){
                        if(!visit[next]){
                            visit[next] = true;
                            q.add(new Floor(next, cur.cnt + 1));
                        }
                    }                    
                }
            }            
            
        }

        return -1;
    }
}

class Floor{
    int locate;
    int cnt;

    Floor(int locate, int cnt){
        this.locate = locate;
        this.cnt = cnt;
    }
}