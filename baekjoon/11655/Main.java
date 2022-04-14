import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                
        StringBuilder sb = new StringBuilder();
        
        String str = br.readLine();

        for(int i =0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(temp >= 'A' && temp <= 'Z'){
                int tmp = temp + 13;
                if(tmp > 'Z'){
                    int asdf = tmp % 'Z';
                    tmp = 'A' + asdf - 1;
                }
                sb.append((char)tmp);
            } // end of UpperCase

           else if(temp >= 'a' && temp <= 'z'){
                int tmp = temp + 13;
                if(tmp > 'z'){
                    int asdf = tmp % 'z';
                    tmp = 'a' + asdf - 1;
                }
                sb.append((char)tmp);
            } // end of LowerCase

            else{
                sb.append(temp);
            }


        }

        System.out.println(sb);
        
    }
}