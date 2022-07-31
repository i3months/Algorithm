import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Double> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.add(Double.parseDouble(br.readLine()));
        }

        while(true){
            double tmp1 = pq.poll();
            double tmp2 = pq.poll();

            double join = (tmp1 + tmp2) / 2.0;

            pq.add(join);

            if(pq.size() == 1){
                System.out.printf("%.6f", pq.poll());
                return;
            }
        }
        
        
    }
}