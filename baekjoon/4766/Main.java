import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    double a = Double.parseDouble(br.readLine());

    while(true){
      double b = Double.parseDouble(br.readLine());
      if(b == 999.0){
        break;
      }

      double ans = Math.round((b-a)*1000.0) / 1000.0;
      String ans_str = String.format("%.2f", ans);

      sb.append(ans_str).append("\n");  
      a = b;
    }
    System.out.println(sb);

    
    
  }
}
