import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      for(int i=0; i<N*2-1; i++){
        for(int j=0; j<i; j++){
          if(j>N){
            continue;
          }else{
            System.out.print("*");
          }
        }
        for(int j=i; j<N*2; j= j+2){
          System.out.print(" ");
        }
        for(int j=0; j<i; j++){
          if(j>N){
            continue;
          }else{
            System.out.print("*");
          }
        }

        System.out.println();

      }



    }
}