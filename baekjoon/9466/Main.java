import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    

    static int N;
    static int[] arr;
    static int cnt;
    static boolean[] visit;
    static boolean[] fin;    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());        

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N+1];
            visit = new boolean[N + 1];
            fin = new boolean[N + 1];
            cnt = 0;

            for(int i=1;i <N+1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<N+1; i++){
                bfs(i);
            }

            sb.append(N - cnt + "\n");
            
            
        }

        System.out.println(sb);

                
    }
    static void bfs(int now){
        if(visit[now]){
            return;
        }
        
        visit[now] = true;
        int next = arr[now];

        if(!visit[next]){
            bfs(next);
        }else{
            if(!fin[next]){
                cnt++;
                for(int i = next; i!=now; i=arr[i]){
                    cnt++;
                }
            }
        }
        fin[now]=  true;
        
        

    }
}