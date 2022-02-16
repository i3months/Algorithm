import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      HashMap<String, PriorityQueue<Integer>> hm = new HashMap<>();

      long sum =0;

      for(int i=0; i<N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        int command = Integer.parseInt(st.nextToken());
        String name = st.nextToken();
        if(command==1){
          if(hm.get(name) == null){
            hm.put(name, new PriorityQueue<>(Collections.reverseOrder()));
          }

          PriorityQueue<Integer> pq = hm.get(name);

          int k = Integer.parseInt(st.nextToken());
          for(int j=0; j<k; j++){
            pq.offer(Integer.parseInt(st.nextToken()));
          }
      
          
        }else if(command==2){
          if(hm.get(name) == null){
            hm.put(name, new PriorityQueue<>(Collections.reverseOrder()));
          }
          PriorityQueue<Integer> pq = hm.get(name);

          int temp = 0;
          int num = Integer.parseInt(st.nextToken());
          if(pq.size() > num){
            temp = num;
          }else{
            temp = pq.size();
          }

          for(int j=0; j<temp; j++){
            sum = sum + pq.poll();
          }
        }
      }
      
      System.out.println(sum);

       
    }
}