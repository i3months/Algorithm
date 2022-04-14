import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String str = br.readLine();
            if(str.equals("EOI")){
                break;
            }
            boolean chk = false;
            for(int i=0; i<str.length()-2-1; i++){
                if((str.charAt(i) == 'n' || str.charAt(i) == 'N') && (str.charAt(i+1) == 'e' || str.charAt(i+1) == 'E') && (str.charAt(i+2) == 'm' || str.charAt(i+2) == 'M') && (str.charAt(i+3) == 'o' || str.charAt(i+3) == 'O')){
                    chk = true;
                    break;
                }
            } // end of for i
            if(chk){
                sb.append("Found\n");
            }else{
                sb.append("Missing\n");
            }
        }
        
        System.out.println(sb);
       
    }
}