import java.util.*;
import java.io.*;

public class Main{

  static int N;
  static int[] page_arr = new int[10];
  static int multiply = 1;
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    int start = 1;
    int end = N;

    while(true){
      
      if(start > end){ 
        break;
      }

      while(start % 10 != 0 && start <= end){ // 시작 숫자의 일의 자리 숫자를 0으로 맞춰야 한다.
        unit(start);
        start++;
      }

      if(start > end){
        break;
      }

      while(end % 10 != 9 && start <= end){ // 끝 숫자의 일의 자리 숫자를 9로 맞춰야 한다.
        unit(end);
        end--;
      }

      start = start / 10;
      end = end / 10; // 다음 숫자를 탐색할 때는 10으로 나눠줘야 한다.

      for(int i=0; i<10; i++){ // 답 갱신
        page_arr[i] = page_arr[i] + (end - start + 1) * multiply;
      }

      multiply = multiply * 10;

    }


    for(int i=0; i<10; i++){
      sb.append(page_arr[i]).append(" ");
    }

    System.out.println(sb);



    
  }

  
  static void unit(int k){ // 자릿수를 맞춰주면서 답을 갱신해야 한다.

    while(k > 0){ 
      page_arr[k % 10] = page_arr[k % 10] + multiply;
      k = k / 10;
    }

  }



}