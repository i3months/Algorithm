import java.util.*;

// 1번 문제 거의 다 함

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    if(N == 1){
      System.out.println(2);
    }else if(N == 2){
      System.out.println(4);
    }else if(N == 3){
      System.out.println(8);
    }else if(N == 4){
      System.out.println(16);
    }else{
      System.out.println(32);
    }
    
  }
}