import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<N; j++){
          int temp = Integer.parseInt(st.nextToken());
          if(pq.size() == N){
            if(pq.peek() < temp){
              pq.poll();
              pq.add(temp);
            }
          }else{
            pq.add(temp);
          }
        }
      }

   
   

      System.out.println(pq.poll());


      

       
    }
}