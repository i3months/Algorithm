import java.io.*;
import java.util.*;
 
public class Main {
    
    static int N, M;    
    static int[] entry;     
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());  
        
        entry = new int[N+1];
        list = new ArrayList[N+1];
        
        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
        

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list2 = new ArrayList<>();

            for(int j=0; j<K; j++) {
                int a = Integer.parseInt(st.nextToken());
                list2.add(a);                
            }
             
            for(int j=0; j<list2.size(); j++) {
                for(int k=j+1; k<list2.size(); k++) {
                    list[list2.get(j)].add(list2.get(k));
                    entry[list2.get(k)]++;
                }
            }                        
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<N+1; i++) {
            if(entry[i] == 0) q.add(i);            
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        while(!q.isEmpty()) {
            int cur = q.poll();
            ansList.add(cur);
            
            for(int k : list[cur]) {
                entry[k]--;
                if(entry[k] == 0) q.add(k);
            }
        }

        if(ansList.size() != N) System.out.println(0);
        else

        for(int i=0; i<ansList.size(); i++) {
            System.out.println(ansList.get(i));
        }
        
        
    }
}