import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        String str = br.readLine();

        HashSet<String> hs = new HashSet<>();

        String input = "";

        for(int i=0; i<str.length(); i++){
            input = "";
            for(int j=i; j<str.length(); j++){
                input = input + str.substring(j,j+1);
                hs.add(input);
            }    
        }
        System.out.println(hs.size());


    }
}