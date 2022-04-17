import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_A = new StringBuilder();
        StringBuilder sb_T = new StringBuilder();


        sb_A.append(br.readLine());
        sb_T.append(br.readLine());

        while(true){

          boolean chk = false;        

          for(int i=0; i<sb_T.length() - sb_A.length()+1; i++){

            if(sb_T.charAt(i) == sb_A.charAt(0)){
              for(int j=1; j<sb_A.length(); j++){
                if(sb_T.charAt(i+j) != sb_A.charAt(j)){
                  chk = false;
                  break;
                }else{
                  chk = true;
                }
              } // end of for j
              if(chk){
                sb.append(sb_T.substring(0,i)).append(sb_T.substring(i+ sb_A.length(),sb_T.length()));                
                sb_T.setLength(0);
                sb_T.append(sb.toString());
                break;
              }
            } 
          } // end of for i

          

          if(!chk){
            break;
          }

          chk = false;   
          sb.setLength(0);    

          for(int i=sb_T.length()-1; i>=0; i--){

            if(sb_T.charAt(i) == sb_A.charAt(sb_A.length()-1)){
              for(int j=1; j<sb_A.length(); j++){
                if(sb_T.charAt(i-j) != sb_A.charAt(sb_A.length()-j-1)){ // need to fix
                  chk = false;
                  break;
                }else{
                  chk = true;
                }
              } // end of for j
              if(chk){
                sb.append(sb_T.substring(0,i-sb_A.length()+1)).append(sb_T.substring(i+1,sb_T.length()));              
                sb_T.setLength(0);
                sb_T.append(sb.toString());
                break;
              }
            } 
          } // end of for i

          if(!chk){
            break;
          }

          

        }// end of while

        System.out.println(sb_T);
        

    }
}