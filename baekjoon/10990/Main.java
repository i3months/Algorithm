import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int N = Integer.parseInt(br.readLine());

      char[][] arr = new char[N][2*N-1];
      
      for(int i=0; i<N; i++){
        for(int j=0; j<2*N-2; j++){
          arr[i][j] = ' ';
        }
       
      }

      for(int i=0; i<N; i++){
     
          if(i==0){
            arr[0][N-1] = '*';
          }else{
            arr[i][N-i-1] = '*';
            arr[i][N+i-1] = '*'; 
          }



        
      }
     
      for(int i = 0; i<N-1; i++){
        System.out.print(" ");
      }
      System.out.println("*");

      loop1: for(int i=1; i<N; i++){
        boolean check = false;
        int count =0;
         for(int j=0; j<2*N-1; j++){
          if(arr[i][j]=='*'){
            count++;
          }
          if(count == 2){
            System.out.print(arr[i][j]);
            System.out.println();
            continue loop1;
          }
          System.out.print(arr[i][j]);
        }
        System.out.println();
      }


    }
}