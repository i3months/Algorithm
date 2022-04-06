import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = "";
        String str = "";

        while((input = br.readLine()) != null){
            str = str + input;    
        }

        String[] arr = str.split(",");

        int sum  =0;

        for(int i=0; i<arr.length; i++){
            sum = sum + Integer.parseInt(arr[i]);
        }
      
        System.out.println(sum);
    }
}