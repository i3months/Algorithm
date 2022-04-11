import java.util.*;
import java.io.*;

public class Main3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] st_arr = new Stack[N+1];

        int count = 0;

        for(int i=1; i<N+1; i++){
          st = new StringTokenizer(br.readLine());

          int n = Integer.parseInt(st.nextToken()); 
          int p = Integer.parseInt(st.nextToken());
 
          if(st_arr[n] == null){ // if null create stack and push p
            st_arr[n] = new Stack<>();
            st_arr[n].push(n);
            count++;            

          }else{
            
            if(st_arr[n].isEmpty()){ // if empty just push p 
              st_arr[n].push(p);
              count++;
            }else{
              if(st_arr[n].peek() < p){ // if peek < p count++ and push
                count++;
                st_arr[n].push(p);
              }else if(st_arr[n].peek() == p){ // if peek == p continue
                
              }else if(st_arr[n].peek() > p){ // if peek > p 

                while(true){
                  st_arr[n].pop();
                  count++;
                  
                  if(st_arr[n].isEmpty()){
                    count++;
                    st_arr[n].push(n);
                    break;
                  }

                  if(st_arr[n].peek() == p){
                    break;

                  }else if(st_arr[n].peek() < p){
                    count++;
                    st_arr[n].push(p);
                    break;

                  }
                } // end of while

              }
            }
          }
          
          
        }
        
        System.out.println(count);

    }


}