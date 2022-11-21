import java.io.*;
import java.util.*;
 
public class Main {

    static final int INF = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> stringToIdx = new HashMap<>();
        HashMap<Integer, String> idxToString = new HashMap<>();

        ArrayList<String> people = new ArrayList<>();
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        ArrayList<Integer>[] children = new ArrayList[N + 1];
        int[] inDegree = new int[N + 1];

        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            String a = st.nextToken();
            people.add(a);
        }

        Collections.sort(people);

        int idx = 0;

        for(String k : people) {
            stringToIdx.put(k, idx);
            idxToString.put(idx, k);

            idx++;
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            String child = st.nextToken();
            String parent = st.nextToken();

            int childIdx = stringToIdx.get(child);
            int parentIdx = stringToIdx.get(parent);

            inDegree[childIdx]++;
            list[parentIdx].add(childIdx);
        }

        ArrayList<String> ancestor = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            if(inDegree[i] == 0) {
                ancestor.add(idxToString.get(i));                
                q.add(idxToString.get(i));
            }
        }

        System.out.println(ancestor.size());

        for(String k : ancestor) {
            System.out.print(k + " ");
        }
        
        System.out.println();

        while(!q.isEmpty()) {
            String cur = q.poll();
            int curIdx = stringToIdx.get(cur);

            for(int k : list[curIdx]) {
                inDegree[k]--;

                if(inDegree[k] == 0) {
                    q.add(idxToString.get(k));
                    children[curIdx].add(k);
                }
            }
        }


        for(int i=0; i<N; i++) {
            String cur = people.get(i);
            int curIdx = stringToIdx.get(cur);

            Collections.sort(children[curIdx]);
            System.out.print(cur + " " + children[curIdx].size() + " ");            
            
            for(int k : children[curIdx]) {
                System.out.print(idxToString.get(k) + " ");
            }

            System.out.println();
            
        }
        

    }
}