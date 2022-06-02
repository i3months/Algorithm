import java.util.*;
import java.io.*;

public class Main{
  static int N;
  static int M;
  
  static int[] arr;    

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];

    for(int i=0; i<N; i++){
      arr[i] = Integer.parseInt(br.readLine());      
    }        

    Arrays.sort(arr);    

    long ans = BinarySearch();

    System.out.println(ans);
    
    
  }

  static long BinarySearch(){
    long L = 0;
    long R = (arr[N-1]) * 1_000_000_000L; 
    long ans = 0;

    while(L <= R){
      long mid = (L + R) / 2;
      long cnt = 0;

      for(int i=0; i<N; i++){
        cnt = cnt + (mid / arr[i]);
      }

      if(cnt >= M){
        ans = mid;
        R = mid - 1;
      }else{
        L = mid + 1;
      }
      
    }

    return ans;

  }
}