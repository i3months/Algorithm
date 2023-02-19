import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());

        loop : while(TC-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Node[] arr = new Node[n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if( Math.abs(start.r - end.r) + Math.abs(start.c - end.c) <= 1000 ) {
                System.out.println("happy");
                continue loop;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(start);

            while(!q.isEmpty()) {
                Node cur = q.poll();

                if( Math.abs(cur.r - end.r) + Math.abs(cur.c - end.c) <= 1000 ) {
                    System.out.println("happy");
                    continue loop;
                }

                for(int i=0; i<n; i++) {
                    if(arr[i] != null) {
                        if( Math.abs(cur.r - arr[i].r) + Math.abs(cur.c - arr[i].c) > 1000 ) continue;

                        q.add(arr[i]);
                        arr[i] = null;
                    }
                }

            }

            System.out.println("sad");
            
            
            
        }


    }
}

class Node {
    int r, c;

    Node(int r, int c) {
        this.r= r;
        this.c=c;
    }
}
