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

            int sum = 0;

            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    sum = sum + ((i+1) * (str.charAt(i) - 'A' + 1));
                }    
            }

            sb.append(sum + "\n");            
        }


        System.out.println(sb);
   }
}