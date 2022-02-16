import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      for(int i =1; i<N+1; i++){
        for(int j =1; j<i; j++){
          System.out.print(" ");
        }
        for(int k=0; k<2*N-2*i-1+2; k++){
          System.out.print("*");
        }
        System.out.println();
      }




    }
}