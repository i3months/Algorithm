import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    static StringBuilder sb = new StringBuilder();      
    static final int INF = 987654321;  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int TC = Integer.parseInt(br.readLine());

        while(TC-- > 0) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                long a = Long.parseLong(st.nextToken());
                pq.add(a);
            }

            long ans = 0;

            while(true) {
                long num1 = pq.poll();
                if(pq.isEmpty()) break;
                long num2 = pq.poll();
                
                ans += (num1 + num2);
                pq.add(num1 + num2);
                
            }

            sb.append(ans + "\n");


        }

        System.out.print(sb);

    }
}
