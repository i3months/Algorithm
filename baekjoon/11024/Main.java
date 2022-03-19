import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {    
  
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

      int N = Integer.parseInt(br.readLine());

      for(int i=0; i<N; i++){
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){
          int a = Integer.parseInt(st.nextToken());
          sum = sum + a;
        }
        sb.append(sum + "\n");
      }

      System.out.println(sb);
  
  }
}

