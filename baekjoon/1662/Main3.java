import java.util.*;
import java.io.*;

public class Main3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();

        Stack<String> st = new Stack<>();

        for(int i = 0; i<str.length(); i++){          
          String input = String.valueOf(str.charAt(i));

          String temp = "";

          if(input.equals(")")){

            while(true){
              if(st.peek().equals("(")){
                break;
              }else{
                sb.append(st.pop());
              }              
            } // while end

            st.pop();
            int repeat = Integer.parseInt(st.pop());
            
            temp = sb.reverse().toString();

            for(int j=0; j<repeat; j++){
              st.push(temp);
            }

          }else{ // case ) end
            st.push(input);
          }  
          sb.setLength(0);
        } // end of i

        
        StringBuilder sb2 = new StringBuilder();

        for(int i=0; i<st.size(); i++){
          sb2.append(st.get(i));
        }

        String ans = sb2.toString();
      
        System.out.println(ans.length());

    }


}