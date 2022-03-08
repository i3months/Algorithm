import java.util.*;
import java.io.*;

public class Main{

  static int N;
  static int[] page_arr = new int[10];
  static int multiply = 1;
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    int countA = 0;
    int countB = 0;

    if(A == 1){
      countA++;
    }else{
      countB++;
    }

    if(B == 1){
      countA++;
    }else{
      countB++;
    }

    if(C == 1){
      countA++;
    }else{
      countB++;
    }

    if(countA>countB){
      System.out.println(1);

    }else{
      System.out.println(2);
    }

  }
}