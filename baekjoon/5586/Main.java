import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i=0; i<str.length()-2; i++){
            if(str.charAt(i) == 'J' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){
                cnt1++;
            }
            if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I'){
                cnt2++;
            }
            
            
            
                
        }
        
        System.out.println(cnt1 + "\n" + cnt2);
        
    }
}