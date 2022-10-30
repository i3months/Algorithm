import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] list;
    static ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
    static boolean[] is_scc;    
    static int[] visited_order;
    static Stack<Integer> st = new Stack<>();

    static int order = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];        
        visited_order = new int[N + 1];
        is_scc = new boolean[N + 1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for(int i=1; i<N+1; i++){
            if(visited_order[i] == 0){
                FindScc(i);
            }
        }

        for(ArrayList<Integer> k : list2){
            Collections.sort(k);
        }

        Collections.sort(list2, (a,b) -> a.get(0) - b.get(0));

        System.out.println(list2.size());
        
        for(ArrayList<Integer> k : list2){
            for(int l : k){
                System.out.print(l + " ");
            }
            System.out.println(-1);
        }
        
    }

    static int FindScc(int cur){
        order++;
        visited_order[cur] = order;

        int min_order = visited_order[cur];
        st.push(cur);

        int next = 0;

        for(int k : list[cur]){
            next = k;
            if(visited_order[next] == 0){
                min_order = Math.min(min_order, FindScc(next));
            }else if(!is_scc[next]){
                min_order = Math.min(min_order, visited_order[next]);
            }
        }

        if(min_order == visited_order[cur]){
            int temp = 0;
            ArrayList<Integer> new_scc = new ArrayList<>();
            while(true){
                temp = st.pop();
                is_scc[temp] = true;
                new_scc.add(temp);

                if(temp == cur) break;
            }

            list2.add(new_scc);
        }
        
        return min_order;
    }
}
