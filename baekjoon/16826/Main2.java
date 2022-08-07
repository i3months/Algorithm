import java.util.*;
import java.io.*;
import java.math.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

       int val = 0;
       int v2 = 0;
       int cnt = 0;

       for(int i=0; i<str.length(); i++){
        if(str.charAt(i) == 'R'){
          val++;
          v2++;
        }else{
          val--;
          v2--;
        }

        if(v2 == 4){
          cnt++;
        }

        if(v2 <= 0){
          v2 = Integer.MAX_VALUE;
        }

        if(val % 4 == 0){
          v2 = 0;
        }

       }

       System.out.println(cnt);
        
    }
}