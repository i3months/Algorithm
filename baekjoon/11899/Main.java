import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Stack<Character> st = new Stack<>();
    int cnt = 0;

    for(int i=0; i<str.length(); i++){
      char cmd = str.charAt(i);

      if(cmd == '('){
        st.push(cmd);
      }

      if(cmd == ')'){
        if(st.isEmpty()){
          cnt++;
        }else{
          st.pop();
        }  
        
      }

    }

    while(!st.isEmpty()){
      st.pop();
      cnt++;
    }

    System.out.println(cnt);


  }
}
