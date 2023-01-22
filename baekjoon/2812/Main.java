import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n, k;

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        
        Deque<Character> dq = new LinkedList<>();

        for(int i=0; i<n; i++) {
            while(true) {
                if(dq.isEmpty()) break;
                if(dq.getLast() >= str.charAt(i)) break;
                if(k == 0) break;

                k--;
                dq.pollLast();
            }
            dq.addLast(str.charAt(i));
        }

        // for(char p : dq) {
        //     System.out.print(p);
        // }

        int len = dq.size() - k;
        
        for(int i=0; i<len; i++) {
            System.out.print(dq.pollFirst());
        }
        
        
        

    }   
}
