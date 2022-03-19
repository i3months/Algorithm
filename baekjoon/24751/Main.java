import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      int N =  Integer.parseInt(br.readLine());

      double ans1 = 100.0 / N;
      double ans2 = 100.0 / (100 - N);
      
      System.out.println(ans1);
      System.out.println(ans2);


    }
}