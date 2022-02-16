import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());



      for(int i=1; i<N+1; i++){
        for(int k = N; k>i; k--){
          System.out.print(" ");
        }
        for(int j=0; j<2*i-1; j++){
          System.out.print("*");
        }
        System.out.println();
      }


    }
}