import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(br.readLine());

      for(int i=0; i<N; i++){
        int k = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        for(int j=0; j<k; j++){
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          char command = st.nextToken().charAt(0);
          int n = Integer.parseInt(st.nextToken());

          if(command == 'I'){
            int value = n;                      
            tm.put(value, tm.getOrDefault(value, 0)+1);          

          }else if(command == 'D'){

            if(tm.size()==0){
              continue;
            }
            
            if(n==1){
              
              int maxkey = tm.lastKey();
              if(tm.get(maxkey) == 1){
                tm.remove(maxkey);
              }else{
                tm.put(maxkey, tm.get(maxkey)-1);
              }

            }else if(n==-1){

              int minkey = tm.firstKey();
              if(tm.get(minkey)== 1){
                tm.remove(minkey);
              }else{
                tm.put(minkey, tm.get(minkey)-1);
              }
            }

            
          }
        }

        if(tm.size()==0){
          sb.append("EMPTY").append("\n");    
        }else{
          sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append('\n');
        }
   

          
     }

        System.out.println(sb);



      }
    }