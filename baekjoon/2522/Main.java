import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      for(int i=1; i<N+1; i++){
        for(int j=i; j<N; j++){
          System.out.print(' ');
        }
        for(int j=0; j<i; j++){
          System.out.print("*");
        }
        System.out.println();
      }

      for(int i = N-1; i>0; i--){
        for(int j=i; j<N; j++){
          System.out.print(' ');
        }
        for(int j=0; j<i; j++){
          System.out.print("*");
        }
        System.out.println();
      }


     

    }
}