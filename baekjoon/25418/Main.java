import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        q.add(A);
        int[] visit = new int[K + 1];

        Arrays.fill(visit, 1000000000);

        visit[A] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();            
            
            int next1 = cur + 1;

            if(next1 > K){
                continue;
            }

            if(next1 == K){                
                visit[K] = Math.min(visit[K], visit[cur] + 1);
            }else{
                if(visit[next1] > visit[cur] + 1){
                    visit[next1] = visit[cur] + 1;
                    q.add(next1);
                }                
            }

            
            int next2 = cur * 2;

            if(next2 > K){
                continue;
            }

            if(next2 == K){                
                visit[K] = Math.min(visit[K], visit[cur] + 1);
            }else{
                if(visit[next2] > visit[cur] + 1){
                    visit[next2] = visit[cur] + 1;
                    q.add(next2);
                } 
            }


        }

        System.out.println(visit[K]);
        
    }
}