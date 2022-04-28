import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("#")){
                break;
            }

            int cnt = 0;
            
            for(int i=0; i<str.length()-1; i++){
                if(str.charAt(i) == '1'){
                    cnt++;
                }
            }

            if(str.charAt(str.length()-1) == 'e'){
                if(cnt % 2 == 0){
                    sb.append(str.substring(0, str.length()-1) + "0\n");                    
                }else{
                    sb.append(str.substring(0, str.length()-1) + "1\n");                    
                }
            }else if(str.charAt(str.length()-1) == 'o'){
                if(cnt % 2 == 0){
                    sb.append(str.substring(0, str.length()-1) + "1\n");                    
                }else{
                    sb.append(str.substring(0, str.length()-1) + "0\n");                    
                }
            }

        }

        System.out.println(sb);
   }
}