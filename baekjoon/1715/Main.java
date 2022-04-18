import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(int i=0; i<N; i++){
      int temp = Integer.parseInt(br.readLine());
      pq.add(temp);
    }

    int sum = 0;

    if(N == 1){
      sum = 0;
    }else{

      while(true){        

        if(pq.size() < 2){
          break;
        }
        
        int temp1 = pq.poll();
        int temp2 = pq.poll();
               

        pq.add(temp1 + temp2);
        sum = sum + temp1 + temp2;
        
                 
      }// end of while
  
    }
      
    
    

    System.out.println(sum);

    

  }
}
