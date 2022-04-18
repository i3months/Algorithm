import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    LinkedList<Integer> list = new LinkedList<>();

    for(int i=1; i<=N; i++){
      list.addLast(i);
    }

    
    ListIterator<Integer> it = list.listIterator();

    int cnt = 0;

    while(list.size() != 0){

      if(cnt >= M){

        for(int i=0; i<K; i++){

          if(!it.hasPrevious()){
            it = list.listIterator();
            for(int j=0; j<list.size(); j++){
              it.next();
            }
          }

          if(i == K-1){
            System.out.println(it.previous());
            it.remove();
            cnt++;
            if(cnt == M*2){
              cnt = 0;
            }
          }else{
            it.previous();
          }

        }

      }else{
        for(int i=0; i<K; i++){    

          if(!it.hasNext()){
            it = list.listIterator();
          }        
          
  
          if(i == K-1){
            System.out.println(it.next());
            it.remove();
            cnt++;
          }else{
            it.next();
          }
  
          
        }     
      }

                 
    } // end of while 



  }
}
