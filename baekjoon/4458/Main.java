import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            String ans = "";
            if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z'){
                ans = str.charAt(0) + "";
            }else{
                ans = (char)(str.charAt(0) - 32) + "";    
            }
            
            ans = ans + str.substring(1,str.length());
            sb.append(ans + "\n");
        }
        
        System.out.println(sb);
        
        
    }
}