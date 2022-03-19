import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int ans = 0;
      try{
        while(true){
        int N = Integer.parseInt(st.nextToken());
        if(N > 0){
          ans++;
        }
      }
    }catch(Exception e){
      System.out.println(ans);
    }


    }
}