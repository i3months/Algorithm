import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++){
            int temp = str.charAt(i) - 3;
            if(temp < 'A'){
                temp ='Z'-('A' - temp)+1;
            }
            
            sb.append((char)temp);
        }
        
        System.out.print(sb);
    }
}