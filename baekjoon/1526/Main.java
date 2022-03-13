import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String tt = ""; 

    loop1:for(int i = N; i>0; i--){
      String temp = String.valueOf(i);
      boolean check = false;

      for(int j=0; j<temp.length(); j++){
        if(temp.charAt(j) == '7' || temp.charAt(j) == '4'){
          check = true;
          if(j == temp.length()-1){
            if(check){
              tt = temp;
              break loop1;
            }
          }
            
        }else{
          check = false;
          break;
        }

        
      }
    }

    System.out.println(tt);


  }
}