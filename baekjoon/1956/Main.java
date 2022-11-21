import java.io.*;
import java.util.*;
 
public class Main {

    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adj = new int[N + 1][N + 1];

        for(int i=0; i<N+1; i++) {
            for(int j=0; j<N+1; j++) {
                adj[i][j] = INF; 
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a][b] = c;
        }

        // for(int i=1; i<N+1; i++) adj[i][i] = 0;

        for(int k=1; k<N+1; k++) {
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }

        
        int ans = INF;
        for(int i=1; i<N+1; i++) {            
            ans = Math.min(ans, adj[i][i]);
        }

        if(ans == INF){
            System.out.println(-1);
            System.exit(0);
        } 

        System.out.println(ans);
        System.exit(0);

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {

                if(adj[i][j] == INF) System.out.print("#" + " "); else
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        
        
        
    }
}