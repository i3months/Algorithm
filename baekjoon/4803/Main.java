import java.io.*;
import java.util.*;

public class Main {

    static int N, M, start;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = 1;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            list = new ArrayList[N + 1];
            visit = new boolean[N + 1];

            int ans = 0;

            for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
            
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            for(int i=1; i<N+1; i++){
                if(!visit[i]){
                    if(dfs(i, 0)){
                        ans++;
                    }
                }
            }

            sb.append("Case ").append(TC);
            if(ans == 0) sb.append(": No trees.");
            else if(ans == 1) sb.append(": There is one tree.");
            else sb.append(": A forest of " + ans + " trees.");
            
            sb.append("\n");
            
            TC++;
        }
        System.out.println(sb);

    }

    static boolean dfs(int cur, int before){
        visit[cur] = true;

        for(int k : list[cur]){
            if(k == before) continue;
            if(visit[k]) return false;
            if(!dfs(k, cur)) return false;
        }

        return true;
    }
}


class Locate{
    int x, y;
    int key = 0;
    Locate(int r,int c){this.x=r;this.y=c;}
    Locate(int r, int c, int key){this.x=r;this.y=c;this.key=key;}
}