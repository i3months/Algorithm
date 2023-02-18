import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n, c, m;

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        Node[] arr = new Node[m];
        ArrayList<Node> list = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        // for(int i=0; i<m; i++) {
        //     System.out.println(arr[i].from + " " + arr[i].to + " " + arr[i].weight);
        // }

        int cur = 0;
        int delivery = 0;
        int[] capacity = new int[n+1];

        for(int i=0; i<m; i++) {
            int cnt = 0;

            for(int j=arr[i].from; j<arr[i].to; j++) {
                cnt = Math.max(cnt, capacity[j]);                
            }

            int left = Math.min(arr[i].weight, c - cnt);
            delivery += left;
            
            for(int j=arr[i].from; j<arr[i].to; j++) {
                capacity[j] += left;
            }
            
        }

        System.out.println(delivery);
        
    }
}

class Node implements Comparable<Node>{
    int from, to, weight;

    Node(int from, int to, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o2) {
        if(o2.to < to) {
            return 1;
        } else if(o2.to > to) {
            return -1;
        } else {
            return from - o2.from;
        }
    }
}
