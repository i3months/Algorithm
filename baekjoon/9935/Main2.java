import java.util.*;
import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i =0; i<str.length(); i++){
          st.push(str.charAt(i));

          if(st.size() >= bomb.length()){
            boolean chk = true;

            for(int j=0; j<bomb.length(); j++){
              if(st.get(st.size()-bomb.length() + j) != bomb.charAt(j)){
                chk = false;
                break;
              }                        
            }
            
            if(chk){
              for(int k=0; k<bomb.length(); k++){
                st.pop();
              }
            }
          }
        }

        if(st.empty()){
          System.out.println("FRULA");
        }else{
          for(int i=0; i<st.size(); i++){
  
            sb.append(st.get(i));
          }
        }

        System.out.println(sb);
        
        
      

    }


}