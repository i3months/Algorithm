import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      String str = br.readLine();

      long sum = 0;
      String temp1 = "";
      boolean chk = false;

      for(int i=0; i<str.length(); i++){
        if(i == str.length() - 1){
          if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            temp1 = temp1 + String.valueOf(str.charAt(i));
            sum = sum + Integer.parseInt(temp1);
          }
        }

        if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
          temp1 = temp1 + String.valueOf(str.charAt(i));
          chk = true;
        }


        if(chk && !(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
          sum = sum + Integer.parseInt(temp1);
          temp1 = "";
          chk = false;
        }
      }


      System.out.println(sum);
      
      
    }
}