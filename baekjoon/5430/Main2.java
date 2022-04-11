import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
          Queue<Character> q = new LinkedList<>();  

          String func = br.readLine();

          for(int j =0; j<func.length(); j++){
            q.offer(func.charAt(j));
          }
          
          int M = Integer.parseInt(br.readLine());
          
          Deque<Integer> list = new ArrayDeque<>();
          
          if(M == 0){
            String array = br.readLine();
          }else{
            String array = br.readLine();
            array = array.substring(1,array.length());
            array = array.substring(0,array.length()-1); 
  
            String[] str_arr = array.split(",");
  
            for(int k=0; k<str_arr.length; k++){
              list.add(Integer.parseInt(str_arr[k]));
            }
          }

          

       

          boolean chk = false;
          boolean direction = false;
          while(true){

            if(q.isEmpty()){
              break;
            }

            char command = q.poll();            

            if(command == 'R'){
              direction = !direction;
            }



            if(command == 'D'){
              if(list.isEmpty()){
                chk = true;      
                break;
              }else{

                if(direction){
                  list.pollLast();
                }else{
                  list.pollFirst();
                }
                
                
              }

            }


          }

          if(direction){
            if(chk){
              sb.append("error\n");
            }else{
              sb.append("[");
  
              while(true){
  
                if(list.isEmpty()){
                  break;
                }
                if(list.size() == 1){
                  sb.append(list.pollLast());  
                }else{
                  sb.append(list.pollLast() + ",");
                }
                
  
                
                
              }
              sb.append("]\n");
              
            }
          }else{
            if(chk){
              sb.append("error\n");
            }else{
              sb.append("[");
  
              while(true){
  
                if(list.isEmpty()){
                  break;
                }
                if(list.size() == 1){
                  sb.append(list.poll());  
                }else{
                  sb.append(list.poll() + ",");
                }
                
  
                
                
              }
              sb.append("]\n");
              
            }
          }
          
          
          

        }

        System.out.println(sb);


    }


}