import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        int[] seq = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            list[before].add(after);
            seq[after]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<N+1; i++){
            if(seq[i] == 0){
                pq.add(i);
            }            
        }

        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur + " ");

            for(int next : list[cur]){
                seq[next]--;

                if(seq[next] == 0){
                    pq.add(next);
                }
            }
            
        }

        System.out.println(sb);
        


        
	}
}
