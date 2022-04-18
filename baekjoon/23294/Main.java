import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // kind of webpage
        int Q = Integer.parseInt(st.nextToken()); // number of command 
        int C = Integer.parseInt(st.nextToken()); // cache memory

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<N+1; i++){
          arr[i] = Integer.parseInt(st.nextToken());
        }

        int cache = 0;
        int state = 0;

        Deque<Integer> back = new LinkedList<>();
        Deque<Integer> front = new LinkedList<>();

        for(int i=0; i<Q; i++){
          st = new StringTokenizer(br.readLine());

          char command = st.nextToken().charAt(0);

          switch(command){

            case 'A':
            int locate = Integer.parseInt(st.nextToken());

            while(!front.isEmpty()){
              cache = cache - arr[front.pollLast()];
              if(front.isEmpty()){
                break;
              }
            } // vacate front

            if(state == 0){
              state = locate;
              cache = cache + arr[locate];
            }else{
              back.addLast(state);              
              state = locate;
              cache = cache + arr[locate];
            }

            if(cache > C){
              while(cache > C){
                cache = cache - arr[back.pollFirst()];
              }
            }
            
            break; // end of case A

            case 'B': 
            if(back.isEmpty()){
              break;
            }else{
              front.add(state);
              int temp = back.pollLast();
              state = temp;
            }
            break; // end of case B

            case 'F':
            if(back.isEmpty()){
              break;
            }else{
              back.addLast(state);
              state = front.pollLast();
            }
            break; // end of case F
            
            case 'C':
            LinkedList<Integer> list = new LinkedList<>();
            
            while(true){
              if(back.isEmpty()){
                break;
              }
              int temp = back.pollLast();              
              list.addLast(temp);            
            } // add to list

            
            

            int size = list.size();

            // compress back list
            int start_idx = 0;
            int idx = 0;
            boolean chk = false;

            while(true){

              if(idx >= list.size() - 2){
                break;
              }

              if(list.get(idx) == list.get(idx+1)){

                while(true){
                  chk = true;
                  idx++;
                  if(idx == list.size() - 1){
                    break;
                  }

                  if(list.get(idx) != list.get(idx+1)){
                    break;
                  }
                } // end of while 2

                
              }else{
                idx++;
              }       
              

              if(chk){
                for(int j = start_idx; j<idx; j++){
                  int temp = list.remove(j);
                  cache = cache - arr[temp];
                }
              }
              

              if(chk){
                start_idx++;
              }


              
            } // end of while 1
                        

            while(true){
              if(list.isEmpty()){
                break;
              }
              back.addLast(list.pollLast());
            }


            break; // end of Case C    



          }
        } // end of for

        System.out.println(state);

        if(back.isEmpty()){
          System.out.println(-1);
        }else{
          while(!back.isEmpty()){
            System.out.print(back.pollLast() + " ");
          }
          System.out.println();
        }


        if(front.isEmpty()){
          System.out.println(-1);
        }else{
          while(!front.isEmpty()){
            System.out.print(front.pollLast() + " ");
          }
          System.out.println();
        }



        
      
        
        
    }
}
