import java.io.*;
import java.util.*;

  public class Main {
    public static void main(String[] args) throws IOException{ 

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      int ans = 0;
      for(int i=0; i<N; i++){
        ans = ans + Integer.parseInt(br.readLine());
      }

      ans = ans - (N-1);
      System.out.println(ans);
     
      
    }
  }