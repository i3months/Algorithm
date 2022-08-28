import java.util.*;
import java.io.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                            

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Queue<Jump> q = new LinkedList<>();
        q.add(new Jump(1, 0));

        int min = Integer.MAX_VALUE;
        boolean[] visit = new boolean[N+1];

        visit[1] = true;

        while(!q.isEmpty()){
            Jump cur = q.poll();            

            if(cur.idx == N){
                min = Math.min(min, cur.cnt);
                System.out.println(min);
                return;
                
            }
            
            int val = arr[cur.idx];

            for(int i=1; i<val + 1; i++){
                if(cur.idx + i > N){
                    continue;
                }

                if(visit[cur.idx + i]){
                    continue;
                }

                visit[cur.idx + i] = true;                
                q.add(new Jump(cur.idx + i, cur.cnt + 1));
            }

        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        
       
    }
}

class Jump{
    int idx, cnt;

    Jump(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}