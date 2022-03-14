import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine(), ",");

    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int len = arr.length;

    for(int i =0; i<K; i++){
      for(int j = 0; j<len-1; j++){
        arr[j] = arr[j+1] - arr[j];
      }
      len--;
    }

    for(int i=0; i<len; i++){
      if( i == len-1){
        System.out.print(arr[i]);  
      }else{
      System.out.print(arr[i] + ",");}
    }

    
    
  }

}