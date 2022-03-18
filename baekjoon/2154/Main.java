import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      int N =  Integer.parseInt(br.readLine());
      String N_to_str = String.valueOf(N);
      

      for(int i=1; i<N+1; i++){
        String temp = String.valueOf(i);
        sb.append(temp);
      }
      String num_to_str = sb.toString();
      long ans = 0;
      
      for(int i=0; i<num_to_str.length(); i++){
        if(num_to_str.substring(i, N_to_str.length() +i).equals(N_to_str)){
          ans = i + 1;
          break;
        }
      }

      if(ans == 0){
        
      }

      System.out.println(ans);

      
    }
}