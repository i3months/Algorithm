import java.io.*;
import java.util.*;
 
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[N+1];
        int[] inDegree = new int[N+1];

        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            inDegree[b]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N+1];
        int[] parent = new int[N+1];

        q.add(1);
        dp[1] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            if(cur == 1 && inDegree[1] == 0) break;

            for(Node k : list[cur]) {
                int val = dp[cur] + k.value;
                if(val > dp[k.to]) {
                    dp[k.to] = val;
                    parent[k.to] = cur;
                }

                inDegree[k.to]--;
                if(inDegree[k.to] == 0) q.add(k.to);
            }
        }
        
        System.out.println(dp[1]);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int s = parent[1];

        while(s != 1) {
            ans.add(s);
            s = parent[s];
        }


        System.out.print(1 + " ");
        for(int i=ans.size()-1; i>=0; i--) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("1");

        // for(int k : ans) System.out.print(k + " ");
        
        
    }
}

class Node implements Comparable<Node>{
    int to, value;

    Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o2) {
        return value - o2.value;        
    }
}
