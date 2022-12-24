import java.io.*;
import java.util.*;
 
public class Main {

    static int N, M;
    static ArrayList<Node>[] list; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        int[] arr = new int[N+1];
        int[] inDegree = new int[N+1];
        boolean[] basic = new boolean[N+1];

        for(int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();     
            basic[i] = true;
        }

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            inDegree[b]++;
            basic[a] = false;
            list[a].add(new Node(b, c));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        arr[N] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            int value = arr[cur];

            for(Node k : list[cur]) {
                inDegree[k.val]--;
                arr[k.val] += (value * k.num);

                if(inDegree[k.val] == 0) q.add(k.val);
            }
        }

        for(int i=1; i<N+1; i++) {
            if(basic[i]) System.out.println(i + " " + arr[i]);
        }


    }
}

class Node {
    int val, num;

    Node(int val, int num) {
        this.val = val;
        this.num = num;
    }
}