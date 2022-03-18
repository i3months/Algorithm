import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
    
      while(true){
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if(A == 0 && B == 0 && C ==0 && D == 0 ){
          break;
        }

        while(true){
          if(A == B && B == C && C == D){
            sb.append(cnt + "\n");    
            break;
          }
            int A1 = Math.abs(A - B);
            int B1 = Math.abs(B - C);
            int C1 = Math.abs(C - D);
            int D1 = Math.abs(D - A);
            A = A1;
            B = B1;
            C = C1;
            D = D1;
            cnt++;
          
        }

        
      }

      System.out.println(sb);
      
      
    }
}