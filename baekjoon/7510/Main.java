import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      int N =  Integer.parseInt(br.readLine());

      for(int i=0; i<N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int temp1 = Math.max(a,b);
        int temp2 = Math.max(temp1, c);
        
        if(a>=c){
          int temp = a;
          a = c;
          c = temp;
        }

        if(b>=c){
          int temp = b;
          b = c;
          c = temp;
        }

        if(a * a + b * b == c*c){
          sb.append("Scenario #"+(i+1)+":\nyes\n\n");
        }else{
          sb.append("Scenario #"+(i+1)+":\nno\n\n");
        }


      }

      System.out.println(sb);

    }
}