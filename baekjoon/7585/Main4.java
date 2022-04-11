import java.util.*;
import java.io.*;

public class Main4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
          String str = br.readLine();
          if(str.equals("#")){
            break;
          }
          boolean chk = false;
          Stack<Character> st = new Stack<>();

          for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
              st.push(str.charAt(i));
            }


            

            if(str.charAt(i) == ')'){
              if(st.isEmpty()){
                chk = true;
              }
              if(st.peek() == '('){
                st.pop();
              }else{
                chk = true;
              }
            }

            if(str.charAt(i) == ']'){
              if(st.isEmpty()){
                chk = true;
              }
              if(st.peek() == '['){
                st.pop();
              }else{
                chk = true;
              }
            }

            if(str.charAt(i) == '}'){
              if(st.isEmpty()){
                chk = true;
              }
              if(st.peek() == '{'){
                st.pop();
              }else{
                chk = true;
              }
            }


            
          }

          if(chk || !st.empty()){
            sb.append("Illegal\n");
          }else{
            sb.append("Legal\n");
          }
        }


        System.out.println(sb);
    }


}