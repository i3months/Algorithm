import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int X = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      double K1 = (double)K;

      double ans = 0;
      double ans1 = 0;
      double ans2 = 0;
      double ans3 = 0;



      if(((K1 * 2.0) + (K1 * 4) + K1) <= X){
        ans = (K1 * 2.0) + (K1 * 4) + K1;
        ans = ans * 1000;
      }else if(((K1 * 2.0) + K1 + (K1 / 2.0)) <= X){
        ans1 = (K1 * 2.0) + K1 + (K1 / 2.0);
        ans1 = ans1 * 1000;
      }else if((K1 + (K1 / 2.0) + (K1 / 4.0)) <= X){
        ans2 = ((K1) + (K1 / 2.0) + (K1 / 4.0));
        ans2 = ans2 * 1000;
      }else{
        ans3 = 0;
      }
     
      

      ans = Math.max(ans,ans1);
      ans = Math.max(ans,ans2);
      ans = Math.max(ans,ans3);
      
      int ans123 = (int)ans;

      System.out.println(ans123);
      
    }
}