import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        while(true){
            String str = br.readLine();
            
            if(str.equals("END")){
                break;
            }// end of if
            sb = new StringBuilder();
            
            for(int i=0; i<str.length(); i++){
                sb.append(str.charAt(i));
            }
            
            sb.reverse();
            
            sb.append("\n");
            sb2.append(sb.toString());
            
            
        }
        System.out.print(sb2);
    }
}