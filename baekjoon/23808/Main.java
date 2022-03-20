import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    char[][] arr = new char[N*5][N*5];

    for(int i=0; i<N*5; i++){
      Arrays.fill(arr[i], '@');
    }

    for(int i=0; i<N*5; i++){
      for(int j = 0; j<N*5; j++){
        if((i >= 0 && i < N*2) || (i >= (N*2 + N) && i < (N * 2 + N + N))){
          if(j >= N && j< N*4){
            arr[i][j] = ' ';
          }
            
          }
      }
    }


    for(int i=0; i<N*5; i++){
      for(int j = 0; j<N*5; j++){
          System.out.print(arr[i][j]);
      }
      System.out.println();
    }



  }
}
