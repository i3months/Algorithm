import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        loop1 : while(TC-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            int[] inDegree = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++) arr[i] = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[N+1];
            for(int i=1; i<N+1; i++) list[i] = new ArrayList<>();

            for(int i=1; i<N+1; i++) {
                int from = arr[i];

                for(int j=i+1; j<N+1; j++) {
                    list[from].add(arr[j]);
                    inDegree[arr[j]]++;
                }
            }

            int M = Integer.parseInt(br.readLine());            

            for(int i=1; i<M+1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if(list[a].contains(b)) {
                    list[a].remove(new Integer(b));
                    list[b].add(a);
                    inDegree[a]++;
                    inDegree[b]--;
                } else

                {
                    list[b].remove(new Integer(a));
                    list[a].add(b);
                    inDegree[b]++;
                    inDegree[a]--;
                }
            }

            Queue<Integer> q = new LinkedList<>();

            int cnt = 0;
            for(int i=1; i<N+1; i++) {if(inDegree[i] == 0) {
                cnt++; q.add(i);
            }}

            if(cnt > 1) {
                sb.append("?" + "\n");
                continue;
            }

            StringBuilder sb2 = new StringBuilder();

            for(int i=1; i<N+1; i++) {
                if(q.isEmpty()) {
                    sb.append("IMPOSSIBLE\n");                                   
                    continue loop1;
                }
                
                int from = q.poll();
                sb2.append(from + " ");

                for(int to : list[from]) {
                    inDegree[to]--;
                    if(inDegree[to] == 0) q.add(to);
                }
            }

            sb.append(sb2.toString() + "\n");
            

        }

        System.out.println(sb);

    }
}