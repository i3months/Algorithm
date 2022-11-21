import java.io.*;
import java.util.*;
 
public class Main {

    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        int[] indegree = new int[N + 1];
        int[] build = new int[N + 1];

      
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());            

            list[a].add(b);
            indegree[b]++;
            
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if(cmd == 1) {
                if(indegree[a] > 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    build[a]++;
                    
                    for(int k : list[a]) {
                        indegree[k]--;
                    }
                }
            }

            if(cmd == 2) {
                if(build[a] == 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    build[a]--;
                    if(build[a] == 0) {
                        for(int k : list[a]) {
                            indegree[k]++;
                        }
                    }                    
                }
            }
        }
        

        System.out.println("King-God-Emperor");
        
    }
}