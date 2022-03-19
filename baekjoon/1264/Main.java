import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {    
  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();


      while(true){
        int ans = 0;
        String str = br.readLine();
        if(str.equals("#")){
          break;
        }
        for(int i=0; i<str.length(); i++){
          if(str.charAt(i) == 'a'||str.charAt(i) == 'e'||str.charAt(i) == 'i'||str.charAt(i) == 'o'||str.charAt(i) == 'u'){
            ans++;
          }
        }
        sb.append(ans+"\n");
      }

      System.out.println(sb);
  
  }
}

