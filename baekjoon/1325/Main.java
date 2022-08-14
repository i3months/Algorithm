import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    static ArrayList<Integer>[] list;

    static int N, M;    
    static int max  = 0;
    static ArrayList<Computer> ans_list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for(int i=0; i<N + 1; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[B].add(A);
        }

        for(int i=1; i<N+1; i++){
            int tmp = bfs(i);
            max = Math.max(max, tmp);
            ans_list.add(new Computer(i, tmp));            
        }
        

        for(Computer k : ans_list){
            if(k.cnt == max){
                sb.append(k.idx + " ");
                // System.out.print(k.idx + " ");
            }
        }

        System.out.println(sb);

        

        

    }

    static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[N + 1];

        q.add(start);
        visit[start] = true;
        
        int cnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int k : list[cur]){
                if(visit[k]){
                    continue;
                }

                q.add(k);
                cnt++;
                visit[k] = true;
            }
            
        }

        return cnt;

        
    }
}

class Computer{
    int idx, cnt;
    Computer(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}