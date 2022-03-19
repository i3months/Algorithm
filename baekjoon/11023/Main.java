import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {    
  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = 0;
      while(st.hasMoreTokens()){
        int a = Integer.parseInt(st.nextToken());
        s = s + a;
      }
      System.out.println(s);
    
  }
}

