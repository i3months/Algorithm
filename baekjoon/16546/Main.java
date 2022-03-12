import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    boolean[] arr = new boolean[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for(int i=0; i<N-1; i++){
      int temp = Integer.parseInt(st.nextToken());
      arr[temp-1] = true;
    }


    for(int i=0; i<N; i++){
      if(arr[i] == false){
        System.out.println(i+1);
      }
    }

  }
}